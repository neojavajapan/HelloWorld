function sortFunction() {
	const selectBox = document.getElementById('sort');
	const str = selectBox.options[selectBox.selectedIndex].value;
	const sortInput = document.getElementById('sortInput');
	sortInput.value = str;
	const sortForm = document.getElementById('sortForm');
	sortForm.submit();
}
