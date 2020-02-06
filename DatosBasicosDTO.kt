data class DatosBasicosDTO (

	val fechaEmisionTransf : String,
	val impTransferencia : Double,
	val impComision : Int,
	val impGastos : Int,
	val impLiquido : Double,
	val nombreOrdenante : String,
	val descCuentaAbono : String,
	val descCuentaCargo : String,
	val impTotalDivBase : String?
)
