
import com.example.codelab.movie.character.core.common.Resource
import com.example.codelab.movie.character.data.api.CharacterApi
import com.example.codelab.movie.character.domain.repository.CharacterRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


@ViewModelScoped
class CharactersRepositoryImpl @Inject constructor(private val characterApi: CharacterApi) :
    CharacterRepository {

    override fun getAllCharacters(): Flow<Resource<List<Unit>>> = flow {
        emit(Resource.Loading())

        val result = characterApi.getAllCharacters().map { it.toDomainCharacter() }

        emit(Resource.Success(result))
    }.flowOn(Dispatchers.IO)
        .catch { e ->
            emit(Resource.Error(e.message ?: "Unknown error occurred"))
        }
}
