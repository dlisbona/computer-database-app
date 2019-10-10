/**
 * 
 */

$(document).ready(function() {
	$('#computerName').blur(function(event) {
		var name = $('#computerName').val();
		$.get('editcomputer', {
			computerName : name
		}, function(responseText) {
			$('#ajaxcomputerNameResponse').text(responseText);
		});
	});
});
