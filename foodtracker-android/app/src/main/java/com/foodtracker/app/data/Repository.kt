package com.foodtracker.app.data

class Repository(
    remoteDataSource: RemoteDataSource,
    localDataSource: LocalDataSource,
) {
    val remote = remoteDataSource
    val local = localDataSource
}
