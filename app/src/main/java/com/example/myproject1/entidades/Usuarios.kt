package com.example.myproject1.entidades

class Usuarios {
    var id = 0
    var dni = 0
    var nombre: String? = null
    var apellido: String? = null
    var correo: String? = null
    var celular = 0

    override fun toString(): String {
        return "$id $dni $nombre $apellido $correo $celular"
    }

}