package com.example.carrotmarket

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
@Dao
interface ProductDAO {
    @Insert
    fun addProduct(ProductString :ProductEntity)

    @Update
    fun UpdateMyString(ProductString :ProductEntity)

    @Delete
    fun DeleteMyString(ProductString :ProductEntity)

    @Query("SELECT * FROM ProductStringTable")
    fun GetAllMyString(): List<ProductEntity>
}

