/* 登録ボタンを押下 */

$(document).ready(function() {
	var prefecturesIdList = $('#id').data('id')
	var heatmapColors = Array(46);
	$('#jmap').jmap({
	    height: "450px",
	    showHeatmap: true,
	    prefectureBackgroundColor: '#d3d3d3',
	    heatmapConditions: prefecturesIdList, // 色がマッチする条件
	    heatmapColors: heatmapColors.fill("#228b22", 0, 46), 　　　　　 // マッチした場合のヒートマップの色
	    areas: [
	    {code: 1,name: "北海道",number: 1},
	    {code: 2,name: "青森",number: 2},
	    {code: 3,name: "岩手",number: 3},
	    {code: 4,name: "宮城",number: 4},
	    {code: 5,name: "秋田",number: 5},
	    {code: 6,name: "山形",number: 6},
	    {code: 7,name: "福島",number: 7},
	    {code: 8,name: "茨城",number: 8},
	    {code: 9,name: "栃木",number: 9},
	    {code: 10,name: "群馬",number: 10},
	    {code: 11,name: "埼玉",number: 11},
	    {code: 12,name: "千葉",number: 12},
	    {code: 13,name: "東京",number: 13},
	    {code: 14,name: "神奈川",number: 14},
	    {code: 15,name: "新潟",number: 15},
	    {code: 16,name: "富山",number: 16},
	    {code: 17,name: "石川",number: 17},
	    {code: 18,name: "福井",number: 18},
	    {code: 19,name: "山梨",number: 19},
	    {code: 20,name: "長野",number: 20},
	    {code: 21,name: "岐阜",number: 21},
	    {code: 22,name: "静岡",number: 22},
	    {code: 23,name: "愛知",number: 23},
	    {code: 24,name: "三重",number: 24},
	    {code: 25,name: "滋賀",number: 25},
	    {code: 26,name: "京都",number: 26},
	    {code: 27,name: "大阪",number: 27},
	    {code: 28,name: "兵庫",number: 28},
	    {code: 29,name: "奈良",number: 29},
	    {code: 30,name: "和歌山",number: 30},
	    {code: 31,name: "鳥取",number: 31},
	    {code: 32,name: "島根",number: 32},
	    {code: 33,name: "岡山",number: 33},
	    {code: 34,name: "広島",number: 34},
	    {code: 35,name: "山口",number: 35},
	    {code: 36,name: "徳島",number: 36},
	    {code: 37,name: "香川",number: 37},
	    {code: 38,name: "愛媛",number: 38},
	    {code: 39,name: "高知",number: 39},
	    {code: 40,name: "福岡",number: 40},
	    {code: 41,name: "佐賀",number: 41},
	    {code: 42,name: "長崎",number: 42},
	    {code: 43,name: "熊本",number: 43},
	    {code: 44,name: "大分",number: 44},
	    {code: 45,name: "宮崎",number: 45},
	    {code: 46,name: "鹿児島",number: 46},
	    {code: 47,name: "沖縄",number: 47}
	    ]
	});
//	var pref = document.getElementsByClassName("jmap-pref");
//	for (let i = 0; i < pref.length; i++) {
//	  pref[i].onclick = function(e) {   
//	  }
//	}
	document.querySelectorAll('.jmap-pref').forEach((targetBox) => {
		targetBox.addEventListener('click', () =>{
			var prefecturesId = targetBox.attributes.getNamedItem('jmap-uniq').value;
			const browseViewUrl = new URL('http://localhost:8080/trip/registerListView');
			browseViewUrl.searchParams.set('prefecturesId', prefecturesId);
			location.href = browseViewUrl;
//			fetch(browseViewUrl, {
//		      method: 'GET',
//		      headers: {'Content-Type': 'application/json'}
//		    })
			
		})
	});
	
});

