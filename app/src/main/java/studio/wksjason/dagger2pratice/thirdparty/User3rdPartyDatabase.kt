package studio.wksjason.dagger2pratice.thirdparty

import android.content.Context
import studio.wksjason.dagger2pratice.database.UserDatabase

class User3rdPartyDatabase(builder: Builder) : UserDatabase {

    init {
        println("User3rdPartyDatabase object initialize")
    }

    val name: String?
    val size: Int?

    init {
        this.name = builder.name
        this.size = builder.size
    }

    class Builder(ctx: Context) {
        var name: String? = null
            private set
        var size: Int? = null
            private set

        fun name(name: String) = apply { this.name = name }
        fun size(size: Int) = apply { this.size = size }
        fun build() = User3rdPartyDatabase(this)
    }
}