package com.duzi.gudicafeteria_a.repository

import com.duzi.gudicafeteria_a.data.Cafe
import com.duzi.gudicafeteria_a.data.Comment
import com.duzi.gudicafeteria_a.data.Menu
import com.duzi.gudicafeteria_a.data.User
import io.reactivex.Observable
import retrofit2.Call

// room 사용 예정
object LocalAppDataSource: AppDataSource {

    override fun getCafes(date: String, sortType: Int, lat: Double, lon: Double, count: Int): Observable<List<Cafe>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getWeeklyMenus(id: String, start: Long, end: Long): Observable<List<Menu>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCafeById(id: String): Cafe {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCommentsById(id: String): Observable<List<Comment>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun insertComment(comment: Comment): Call<Int> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteComment(cafeId: String, userId: String, seq: Int): Call<Int> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getUserById(id: String): Observable<User> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun insertUser(user: User): Call<Int> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteUser(userId: String): Call<Int> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}