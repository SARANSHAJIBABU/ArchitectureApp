package com.example.architectureapplication.kt

import dagger.Module

@Module(subcomponents = arrayOf(MainComponent::class, AddNoteComponent::class))
class AppSubComponents {
}
