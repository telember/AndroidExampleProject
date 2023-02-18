package share.data.domain

import share.data.data.model.User
import share.data.data.repository.AppRepository

interface GetUserUseCase {
    fun execute(): User?
}

class GetUserUseCaseImpl(
    private val appRepository: AppRepository,
) : GetUserUseCase {

    override fun execute(): User? {
        return appRepository.user
    }
}
