package com.codecool.cyberiashop.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Product(@PrimaryKey val uid: String,
                   @ColumnInfo val title: String,
                   @ColumnInfo val type: String,
                   @ColumnInfo val price: String,
                   @ColumnInfo val details: String,
                   @ColumnInfo val photoURL: String)