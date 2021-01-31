$(function() {
	// solving active menu problem
	switch (menu) {

	case 'About Us':
		$('#about').addClass('active');
		break;

	case 'Contact Us':
		$('#contact').addClass('active');
		break;

	case 'All Products':
		$('#listproducts').addClass('active');
		break;

	default:
		if (menu == "Home")
			break;
		$('#listproducts').addClass('active');
		$('#a_' + menu).addClass('active');
		break;

	}

	// code for jquery datatables

	var $table = $('#productListTable');

	// execute the below code only where we have this table

	if ($table.length) {

		var jsonUrl = '';

		if (window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/products';
		} else {
			jsonUrl = window.contextRoot + '/json/data/category/'
					+ window.categoryId + '/products';
		}

		$table
				.DataTable({

					lengthMenu : [
							[ 3, 5, 10, -1 ],
							[ '3 Records', '5 Records', '10 Records',
									'All Records' ] ],
					pageLength : 5,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},

					columns : [
							{

								data : 'code',
								bSortable : false,
								mRender : function(data, type, row) {

									return '<img src="'
											+ window.contextRoot
											+ '/resources/images/'
											+ data
											+ '.jpg" style="width:100px;height:100px;"/>';

								}
							},
							{
								data : 'name',
							},
							{
								data : 'brand',
							},
							{
								data : 'unitPrice',
								mRender : function(data, type, row) {
									return '&#8377; ' + data
								}

							},
							{
								data : 'quantity',
								mRender : function(data, type, row) {
									if (data < 1) {
										return '<span style="color: red">Out of stock!</span>';
									}
									return data;
								}
							},
							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {
									var str = '';
									str += '<a href="'
											+ window.contextRoot
											+ '/show/'
											+ data
											+ '/product" class="btn btn-outline-primary"><i class="fa fa-fw fa-eye"></i></a> &#160; &#160; &#160; &#160;';

									if (row.quantity < 1) {
										str += '<a href="javascript:void(0)" class="btn btn-outline-primary disabled"><i class="fa fa-fw fa-shopping-cart"></i></a>';

									} else {
										str += '<a href="'
												+ window.contextRoot
												+ '/cart/add/'
												+ data
												+ '/product" class="btn btn-outline-primary"><i class="fa fa-fw fa-shopping-cart"></i></a>';

									}

									return str;

								}
							} ]
				});
	}

});