
$(document).ready(function() {
	$('#computerName').blur(function(event) {
		var name = $('#computerName').val();
		$.get('editcomputer', {
			computerName : name
		}, function(responseText) {
			vide = "\nVide";
			if (responseText === vide) {
				$('#ajaxcomputerNameResponse').text(responseText);
				console.log("notok");
				responseText = "";
			} else {
				$('#ajaxcomputerNameResponse').text("");
				console.log("ok");

			}
		});
	});
});
