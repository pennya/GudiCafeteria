package com.duzi.gudicafeteria_a.repository

import com.duzi.gudicafeteria_a.data.*
import com.duzi.gudicafeteria_a.service.ApiService
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RemoteAppDataSource: AppDataSource {

    private val apiService: ApiService by lazy {
        RemoteAppDataSource.create()
    }

    override fun getCafes(date: String, sortType: Int, lat: Double, lon: Double, count: Int): Observable<List<Cafe>> {
        return apiService.getCafeList(date, sortType, lat, lon, count)
    }

    override fun getWeeklyMenus(id: String, start: Long, end: Long): Observable<List<Menu>> {
        return apiService.getWeeklyMenus(id, start, end)
    }

    override fun getCafeById(id: String): Cafe {
        TODO("not implemented") // 캐시, DB 에 데이터가 없는 경우 네트워크에서 가져온다
    }

    override fun getCommentsById(id: String): Observable<List<Comment>> {
        return apiService.getComments(id)
    }

    override fun insertComment(comment: Comment): Call<Int> {
        return apiService.insertComment(comment)
    }

    override fun deleteComment(cafeId: String, userId: String, seq: String): Call<Int> {
        return apiService.deleteComment(cafeId, userId, seq)
    }

    override fun updateComment(cafeId: String, userId: String, seq: String, score: String, comment: String): Call<Int> {
        return apiService.updateComment(cafeId, userId, seq, score, comment)
    }

    override fun getUserById(id: String): Observable<User> {
        return apiService.getUserById(id)
    }

    override fun insertUser(user: User): Call<Int> {
        return apiService.insertUser(user)
    }

    override fun deleteUser(userId: String): Call<Int> {
        return apiService.deleteUser(userId)
    }

    override fun getFavoritesById(userId: String): Observable<List<Favorite>> {
        return apiService.getFavoritesById(userId)
    }

    override fun insertFavorite(favorite: Favorite): Single<Int> {
        return apiService.insertFavorite(favorite)
    }

    override fun deleteFavorite(cafeId: String, userId: String): Single<Int> {
        return apiService.deleteFavorite(cafeId, userId)
    }

    private fun create(): ApiService {
        val retrofit = Retrofit.Builder()
                .baseUrl(ApiService.HTTP_API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

        return retrofit.create(ApiService::class.java)
    }

}