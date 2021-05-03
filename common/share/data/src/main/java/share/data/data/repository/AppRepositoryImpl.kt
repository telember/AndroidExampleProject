package share.data.data.repository

import share.data.data.model.User

interface AppRepository {
    var user: User?
}
class AppRepositoryImpl : AppRepository {
    override var user: User? = null
}
