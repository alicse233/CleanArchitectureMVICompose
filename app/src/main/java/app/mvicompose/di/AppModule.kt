package app.mvicompose.di

import app.mvicompose.data.remote.UserApi
import app.mvicompose.data.repository.UserRepositoryImpl
import app.mvicompose.domain.repository.UserRepository
import app.mvicompose.domain.usecase.GetRandomUserUseCase
import app.mvicompose.presentation.home.HomeViewModel
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single {
        HttpClient(Android) {
            install(ContentNegotiation) {
                json()
            }
        }
    }
    single { UserApi(get()) }
    single<UserRepository> { UserRepositoryImpl(get()) }
    single { GetRandomUserUseCase(get()) }
    viewModel { HomeViewModel(get()) }
}