function eliminar(id)
{
    swal({
        title: "¿Esta seguro de eliminar?",
        text: "Una vez eliminado, no podrá recuperar este registro",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
    .then((OK) => {
        if (OK) 
        {
            $.ajax({
                url:"/eliminar/"+id,
                success: function(res)
                {
                    console.log(res);
                }
            });
            swal("Registro Eliminado", {
                icon: "success",
            }).then((ok)=>{
				if (ok)
				{
					location.href="/listar";
				}
			});
        }
        else
        {
            swal("El registro esta seguro");
        }
    });
}
function set_nombre_formulario()
{
	if ($("#id_persona").val() > 0)
		$("#titulo").text("Editar Persona");
}