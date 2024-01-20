package com.example.solutionchallenge

class User {
    var name : String? = null
    var email : String? = null
    var uid : String? = null
    var img : String?=null
    var contributor :String?=null
    constructor(){}

    constructor(name:String? , email:String? , uid:String?)
    {
        this.name = name
        this.email = email
        this.uid = uid
    }
    constructor(img:String? , uid:String?)
    {
        this.img = img
        this.uid = uid
    }
    constructor(contributor :String?){
        this.contributor = contributor
    }
}