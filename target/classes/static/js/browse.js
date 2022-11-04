/* 登録ボタンを押下 */
window.onload = function () {
	/* 戻るボタンを押下 */
	document.getElementById('returnButton').onclick = function() {
	  // TOP画面へ遷移
	  window.location.href = 'http://localhost:8080/trip/topView';
	};

	document.getElementById('nextButton').onclick = function(){
		window.location.href = 'http://localhost:8080/trip/editView';
	}
	
	document.getElementById('deleteButton').onclick = function(){
		var myModal = new bootstrap.Modal(document.getElementById('confirm'));
		myModal.show();
	}
	document.getElementById('confirmNext').onclick = function(){
		const url = new URL('http://localhost:8080/trip/delete');
		const tripId = document.getElementById('deleteButton').dataset.tripId;
		url.searchParams.set('tripId',tripId);
		fetch(url, {
			method: 'POST',
			headers: {'Content-Type': 'application/json'}
		})
		.then(response => {
			if(response.status){
				var completion = new bootstrap.Modal(document.getElementById('completion'));
				completion.show();
				
			}
		})
		.catch(error => {
			console.log('通信に失敗しました');
		})
	}
	document.getElementById('completionNext').onclick = function(){
		window.location.href = 'http://localhost:8080/trip/topView';
	}
};