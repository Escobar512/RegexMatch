package com.example.regexmatch

class cards {
    // property (data member)
    private var userId: String
    private var imageUrl: String
    private var name: String

    constructor(userId: String, imageUrl: String ,name: String) {
        this.userId = userId
        this.name = name
        this.imageUrl = imageUrl
    }

    // getter and setter for userId
    fun getUserId(): String {
        return userId
    }

    fun setUserId(userId: String) {
        this.userId = userId
    }

    // getter and setter for imageUrl
    fun getImageUrl(): String {
        return imageUrl
    }

    fun setImageUrl(imageUrl: String) {
        this.imageUrl = imageUrl
    }

    // getter and setter for name
    fun getName(): String {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }

}