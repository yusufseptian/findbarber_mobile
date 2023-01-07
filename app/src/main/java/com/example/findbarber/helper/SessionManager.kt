package com.example.findbarber.helper

import android.content.Context

class SessionManager(var context: Context?, var key : String) {
    private var session = context?.getSharedPreferences(key, 0)
    private var editor  = session?.edit()

    fun set(key: String?, data: String){
        this.editor?.putString(key, data)
        this.editor?.commit()
    }
    fun get(key : String) : String?{
        return this.session?.getString(key, null)
    }
    fun remove(key : String){
        this.editor?.remove(key)
        this.editor?.commit()
    }
    fun destroy(){
        this.editor?.clear()
        this.editor?.commit()
    }
}