
$(document).ready(function() {
	$('#computerName').blur(function(event) {
		var name = $('#computerName').val();
		$.get('editcomputer', {
			computerName : name
		}, function(responseText) {
			vide = "\nVide";
			if (JSON.stringify(responseText).trim === JSON.stringify(vide).trim) {
				$('#ajaxcomputerNameResponse').text(responseText);

			} else if (JSON.stringify(responseText).trim === JSON.stringify("").trim){
				$('#ajaxcomputerNameResponse').text("");

			}
		});
	});
});
