/* 登録ボタンを押下 */
window.onload = function () {
$(function(){
    $('#datepicker-daterange .input-daterange').datepicker({
        language: 'ja',
        format: "yyyy-mm-dd",
        autoclose: true
    });
});
document.getElementById('nextButton').onclick = function() {
	/* 登録確認ダイアログを開く */
	var myModal = new bootstrap.Modal(document.getElementById('confirm'));
	myModal.show();
	//var myModal = new bootstrap.Modal(document.getElementById('confirm'), options)
	};

/* 登録確認ダイアログ　OKボタン押下処理 */
document.getElementById('confirmNext').onclick = function() {
  const fd = new FormData();
  const tripStartDateNum = document.getElementById('tripStartDate').value.replace(/\D/g, '/');
  const tripEndDateNum = document.getElementById('tripEndDate').value.replace(/\D/g, '/');
  fd.append('prefecturesId', document.getElementById('prefectures').value);
  fd.append('tripStartDate', tripStartDateNum);	
  fd.append('tripEndDate', tripEndDateNum);	
  fd.append('accommodationName', document.getElementById('accommodationName').value);	
  fd.append('accommodationInfo', document.getElementById('accommodationInfo').value);	
  fd.append('breakfastShopName', document.getElementById('breakfastShopName').value);	
  fd.append('breakfastInfo', document.getElementById('breakfastInfo').value);	
  fd.append('lunchShopName', document.getElementById('lunchShopName').value);	
  fd.append('lunchInfo', document.getElementById('lunchInfo').value);	
  fd.append('dinnerShopName', document.getElementById('dinnerShopName').value);	
  fd.append('dinnerInfo', document.getElementById('dinnerInfo').value);	
  const obj = Object.fromEntries(fd)
      fetch('http://localhost:8080/trip/register', {
      method: 'POST',
      body: JSON.stringify(obj),
      headers: {'Content-Type': 'application/json'}
    })
    .then(response => {
		if(response.status){
			var completion = new bootstrap.Modal(document.getElementById('completion'));
			completion.show();
//			window.location.herf = 'http://localhost:8080/trip/topView';
		}
//		return response.json();
  })
//  	.then(data => {
//		console.log(data);
//	})
	.catch(error => {
		console.log('通信に失敗しました');
	})
};

document.getElementById('completionNext').onclick = function() {
	window.location.href = 'http://localhost:8080/trip/topView';
};


/* 戻るボタンを押下 */
document.getElementById('returnButton').onclick = function() {
  // TOP画面へ遷移
  window.location.href = 'http://localhost:8080/trip/topView';
};
};