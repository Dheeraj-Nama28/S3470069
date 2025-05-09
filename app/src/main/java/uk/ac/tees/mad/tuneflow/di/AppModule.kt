package uk.ac.tees.mad.tuneflow.di

import com.google.firebase.auth.FirebaseAuth
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import uk.ac.tees.mad.tuneflow.model.repository.AuthRepository
import uk.ac.tees.mad.tuneflow.model.repository.DeezerRepository
import uk.ac.tees.mad.tuneflow.model.repository.NetworkRepository
import uk.ac.tees.mad.tuneflow.model.retrofit.DeezerRetrofitInstance
import uk.ac.tees.mad.tuneflow.model.serviceapi.DeezerApiService
import uk.ac.tees.mad.tuneflow.model.utils.NetworkConnectivityManager
import uk.ac.tees.mad.tuneflow.viewmodel.HomeScreenViewModel
import uk.ac.tees.mad.tuneflow.viewmodel.SignInScreenViewModel
import uk.ac.tees.mad.tuneflow.viewmodel.SignUpScreenViewModel
import uk.ac.tees.mad.tuneflow.viewmodel.SplashScreenViewModel

val appModule = module {
    single { NetworkConnectivityManager(androidContext()) }
    single { NetworkRepository(get()) }

    single<DeezerApiService> { DeezerRetrofitInstance.create() }

    single { FirebaseAuth.getInstance() }
    single { AuthRepository(get()) }

    // Repository
    single { DeezerRepository(get()) }

    // ViewModels
    viewModelOf(::SplashScreenViewModel)
    viewModelOf(::SignInScreenViewModel)
    viewModelOf(::SignUpScreenViewModel)
    viewModelOf(::HomeScreenViewModel)
}