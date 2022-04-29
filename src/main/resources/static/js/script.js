<<<<<<< Updated upstream
/**
 * 
 */
=======
/* global bootstrap: false */
(function () {
  'use strict'
  var tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'))
  tooltipTriggerList.forEach(function (tooltipTriggerEl) {
    new bootstrap.Tooltip(tooltipTriggerEl)
  })
})()

function goProfile() {
	window.location.replace("/users/profile");
}

function goLogOut() {
	window.location.replace("/logout");
}
>>>>>>> Stashed changes
