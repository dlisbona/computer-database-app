
$(document).ready(function() {
	$('#computerName').blur(function(event) {
		var name = $('#computerName').val();
		$.get('editcomputer', {
			computerName : name
		}, function(responseText) {
			if (responseText === "Vide") {
				$('#ajaxcomputerNameResponse').text(responseText);
			} else {
				$('#ajaxcomputerNameResponse').text("");
			}
		});
	});
});
