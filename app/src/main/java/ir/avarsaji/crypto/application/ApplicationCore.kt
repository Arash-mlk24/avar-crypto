package ir.avarsaji.crypto.application

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject


@HiltAndroidApp
class ApplicationCore @Inject constructor() : Application()