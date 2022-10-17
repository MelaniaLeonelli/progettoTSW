$().ready(function() {
	 $('#cf').keyup(function(){
 		this.value=this.value.toUpperCase();
	});
	
	jQuery.validator.addMethod("cf_regex", function(value) { 
        var regex = /[A-Za-z]{6}[0-9lmnpqrstuvLMNPQRSTUV]{2}[abcdehlmprstABCDEHLMPRST]{1}[0-9lmnpqrstuvLMNPQRSTUV]{2}[A-Za-z]{1}[0-9lmnpqrstuvLMNPQRSTUV]{3}[A-Za-z]{1}/;
        return value. match(regex);  
    }, "Formato codice fiscale non valido");
    
    jQuery.validator.addMethod("cf_checkdigit", function(value) { 
        return cf_validation(value);  
    }, "Formato codice fiscale non valido");
    
    $("#form").validate({
        rules : {
            cf : {
				required:true,
				cf_regex : true,
				cf_checkdigit: true
			},
            surname : {
				required: true,
				lettersonly: true,
			},
            name : {
				required: true,
				lettersonly: true,
			},
            email : {
                required : true,
                email : true
            },
            password : {
                required : true,
                minlength : 5,
                maxlength : 8
            },
            address : "required",
            city : "required",
            cap : {
				required: true,
				digits: true,
				minlength : 5,
                maxlength : 5
			},
			phone:{
				digits:true,
				minlength : 9,
                maxlength : 10
			}
        },
        messages: {
			cf : {
				required:"Campo obbligatorio",
				cf_regex : "Formato non valido",
				cf_checkdigit: "Codice fiscale errato"
			},
            surname: {
				required:"Campo obbligatorio",
				lettersonly:"Inserisci un cognome corretto."
			},
			name: {
				required:"Campo obbligatorio",
				lettersonly:"Inserisci un nome corretto."
			},
			email:{
				required:"Campo obbligatorio",
				email:"Formato email invalido"
			},
            password: {
                required: "Campo obbligatorio",
                minlength: "La password deve essere lunga minimo 5 caratteri",
                maxlength: "La password deve essere lunga al massimo 8 caratteri"
            },
            address: "Campo obbligatorio",
            city: "Campo obbligatorio",
            cap : {
				required: "Campo obbligatorio",
				digits: "Il CAP può contenere solo numeri",
				minlength : "CAP errato",
                maxlength : "CAP errato"
			},
			phone:{
				digits:"Formato non corretto",
				minlength : "Formato non corretto",
                maxlength : "Formato non corretto"
			}
        },
        submitHandler: function(form) {
            form.submit();
        }
    });
});


function cf_validation(cf)
      {
          var validi, i, s, set1, set2, setpari, setdisp;
          validi = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
          for( i = 0; i < 16; i++ ){
              if( validi.indexOf( cf.charAt(i) ) == -1 )
              {
				return false;
			  }
          }
          set1 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
          set2 = "ABCDEFGHIJABCDEFGHIJKLMNOPQRSTUVWXYZ";
          setpari = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
          setdisp = "BAKPLCQDREVOSFTGUHMINJWZYX";
          s = 0;
          for( i = 1; i <= 13; i += 2 )
              s += setpari.indexOf( set2.charAt( set1.indexOf( cf.charAt(i) )));
          for( i = 0; i <= 14; i += 2 )
              s += setdisp.indexOf( set2.charAt( set1.indexOf( cf.charAt(i) )));
          if( s%26 != cf.charCodeAt(15)-'A'.charCodeAt(0) )
          {
			//alert("codice fiscale non valido");
			return false;
		  }
		  //alert("codice fiscale valido");
          return true;
}

