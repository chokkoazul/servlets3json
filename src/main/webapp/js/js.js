$(function (){
	
$('#cargar').click(function() {
   
	$.ajax({ 
	    type: "GET", 
	    url: "http://localhost:8080/Servlets3/resources/greeting", 
	    contentType: "application/json; charset=utf-8",
	    dataType: "json",
	    success: function (data) { 
	    	$('#textCargar').val("El mensaje es:"+data.message);
	    },
	    error: function () { 
	    	$('#textCargar').val("Error al cargar mensaje");
	    }
	});

	
	
	
});


$('#enviar').click(function() {
	   
	$.ajax({ 
	    type: "PUT", 
	    url: "http://localhost:8080/Servlets3/resources/greeting", 
	    contentType: "text/plain; charset=utf-8",
	    data: $('#texto').val(),
	    dataType: "plain",
	    success: function (data) { 
	    	$('.mensajeEnviar').append("Ok enviar mensaje|");
		},
	    error: function () { 
	    	$('.mensajeEnviar').append("Error al enviar mensaje|");
		}
	});

	
	
	
});


})
/*
$(document).ready(function() {
	$('#boton').click(function() {

	$.ajax({
        url: "http://localhost:8080/Servlets3/resources/greeting"
    }).then(function(data) {
       $('.greeting-id').append(data.mensaje);
       $('.greeting-content').append(data.mensaje);
    });
    });
});*/