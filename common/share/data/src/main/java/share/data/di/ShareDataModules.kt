package share.data.di

import org.koin.dsl.module
import share.data.domain.GetUserUseCase
import share.data.domain.GetUserUseCaseImpl

val shareDataModule = module {
    factory<GetUserUseCase> { GetUserUseCaseImpl(get()) }
}
