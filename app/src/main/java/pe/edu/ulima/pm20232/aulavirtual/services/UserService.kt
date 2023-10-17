package pe.edu.ulima.pm20232.aulavirtual.services

import pe.edu.ulima.pm20232.aulavirtual.models.User

class UserService {
    var userList: ArrayList<User> = ArrayList<User>()

    constructor(){
        userList.add(User(id = 1, user = "20180038", password = "123", memberId = 1))
        userList.add(User(id = 2, user = "20202370", password = "123", memberId = 2))
        userList.add(User(id = 3, user = "20171869", password = "123", memberId = 3))
        userList.add(User(id = 4, user = "20192566", password = "123", memberId = 4))
        userList.add(User(id = 5, user = "20202712", password = "123", memberId = 5))
        userList.add(User(id = 6, user = "20184660", password = "123", memberId = 6))
        userList.add(User(id = 7, user = "20200711", password = "123", memberId = 7))
        userList.add(User(id = 8, user = "20194065", password = "123", memberId = 8))
        userList.add(User(id = 9, user = "20192303", password = "123", memberId = 9))
        userList.add(User(id = 10, user = "20190857", password = "123", memberId = 10))
        userList.add(User(id = 11, user = "20182686", password = "123", memberId = 11))
        userList.add(User(id = 12, user = "20142881", password = "123", memberId = 12))
        userList.add(User(id = 13, user = "20192985", password = "123", memberId = 13))
        userList.add(User(id = 14, user = "20201166", password = "123", memberId = 14))
        userList.add(User(id = 15, user = "20202407", password = "123", memberId = 15))
        userList.add(User(id = 16, user = "30230242", password = "123", memberId = 16))
        userList.add(User(id = 17, user = "20191291", password = "123", memberId = 17))
        userList.add(User(id = 18, user = "20191301", password = "123", memberId = 18))
        userList.add(User(id = 19, user = "20191412", password = "123", memberId = 19))
        userList.add(User(id = 20, user = "20152154", password = "123", memberId = 20))
        userList.add(User(id = 21, user = "20191937", password = "123", memberId = 21))
        userList.add(User(id = 22, user = "20203668", password = "123", memberId = 22))
        userList.add(User(id = 23, user = "20203703", password = "123", memberId = 23))
        userList.add(User(id = 24, user = "20192003", password = "123", memberId = 24))
        userList.add(User(id = 25, user = "20193553", password = "123", memberId = 25))
        userList.add(User(id = 26, user = "20162609", password = "123", memberId = 26))
        userList.add(User(id = 27, user = "20172768", password = "123", memberId = 27))
        userList.add(User(id = 28, user = "20183460", password = "123", memberId = 28))
    }

    fun checkUser(userName: String, password: String): Int{
        var resp: Int = 0
        userList.forEach{user ->
            if(user.user == userName && user.password == password){
                resp = user.id
            }
        }
        return resp
    }
}