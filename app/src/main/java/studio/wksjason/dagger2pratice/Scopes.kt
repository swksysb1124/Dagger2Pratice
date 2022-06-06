package studio.wksjason.dagger2pratice

import javax.inject.Scope

@Scope
@MustBeDocumented
@Retention(value = AnnotationRetention.RUNTIME)
annotation class ActivityScope


@Scope
@MustBeDocumented
@Retention(value = AnnotationRetention.RUNTIME)
annotation class ViewModelScope
