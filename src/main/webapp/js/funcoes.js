function repitaSenha(input) {
	if (input.value != document.getElementById("senha").value) {
		input.setCustomValidity('Repita a Senha')
	} else {
		input.setCustomValidity('')
	}
}
