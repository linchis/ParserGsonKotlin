
val strjson = "{\"inmediata\":{\"error\":\"0\",\"descError\":null,\"datosBasicos\":{\"fechaEmisionTransf\":\"09/01/2020\",\"impTransferencia\":10.12,\"impComision\":6.0,\"impGastos\":0.0,\"impLiquido\":16.12,\"nombreOrdenante\":\"SUPERMAN\",\"descCuentaAbono\":\"CR 99 11111111122233444555\",\"descCuentaCargo\":\"ES 00 98765432100000000000\",\"impTotalDivBase\":null},\"listaComisiones\":null},\"urgente\":{\"error\":\"0\",\"descError\":\"PL_5304\",\"datosBasicos\":{\"fechaEmisionTransf\":\"09/01/2020\",\"impTransferencia\":10.12,\"impComision\":2.0,\"impGastos\":0.0,\"impLiquido\":12.12,\"nombreOrdenante\":\"SUPERMAN\",\"descCuentaAbono\":\"CR 99 11111111122233444555\",\"descCuentaCargo\":\"ES 00 98765432100000000000\",\"impTotalDivBase\":null},\"listaComisiones\":null},\"estandar\":{\"error\":\"0\",\"descError\":null,\"datosBasicos\":{\"fechaEmisionTransf\":\"09/01/2020\",\"impTransferencia\":10.12,\"impComision\":2.0,\"impGastos\":0.0,\"impLiquido\":12.12,\"nombreOrdenante\":\"SUPERMAN\",\"descCuentaAbono\":\"CR 99 11111111122233444555\",\"descCuentaCargo\":\"ES 00 98765432100000000000\",\"impTotalDivBase\":null},\"listaComisiones\":null}}"

private fun parserCurrencyJson(stringInput:String):Map<String,Currency> {
    val decoded: Map<String, CurrencyDTO> = Gson().fromJson(
        stringInput,
        object : TypeToken<Map<String?, CurrencyDTO?>?>() {}.type
    )
    val dataMap = mutableMapOf<String, Currency>()
    decoded.forEach { (k, v) ->
        dataMap[k] = Currency(k,v.error,v.descError,Gson().fromJson<DatosBasicos>(Gson().toJson(v.datosBasicos),DatosBasicos::class.java),v.listaComisiones)
    }
    //TEST
    dataMap.forEach{ (k,v) ->
        println(v.toString())
    }
    return dataMap
}
