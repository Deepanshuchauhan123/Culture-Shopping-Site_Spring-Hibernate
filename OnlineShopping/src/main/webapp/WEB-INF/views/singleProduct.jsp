<div class="container">

	<!-- Breadcrunb -->

	<div class="row">

		<div class="col-xs-12">

			<ol class="breadcrumb">

				<li><a href="${contextRoot}/home">Home /</a></li>
				<li><a href="${contextRoot}/show/all/products"> Products /</a></li>
				<li class="active">${product.name}</li>

			</ol>

		</div>

	</div>

	<div class="row">
		<!-- Display the product image -->
		<div class="col-xs-12 col-sm-4">

			<div class="thumbnail">

				<img src="${images}/${product.code}.jpg" class="img img-respomsive" />

			</div>

		</div>

		<!-- Display the product desc -->
		<div class="col-xs-12 col-sm-8">


			<h3>${product.name}</h3>
			<hr />

			<p>${product.description}</p>
			<hr />

			<h4>
				Price: <strong>&#8377; ${product.unitPrice} /-</strong>
			</h4>
			<hr />



			<!-- Showing product quantity if 0 then out of stock else product quantity -->
			<c:choose>
				<c:when test="${product.quantity<1}">
					<h6>
						Qty. Available: <span style="color: red">Out of stock!</span>
					</h6>
				</c:when>
				<c:otherwise>
					<h6>Qty. Available: ${product.quantity}</h6>

				</c:otherwise>
			</c:choose>
			<!-- if no product available then add to cart disabled -->
			<c:choose>
				<c:when test="${product.quantity<1}">
					<!-- Disabled Add to cart Button -->
					<a href="javascript:void(0)" class="btn btn-success disabled"><del>
							<i class="fa fa-fw fa-shopping-cart"></i> Add to Cart
						</del> </a>

				</c:when>
				<c:otherwise>
					<!-- Add to cart Button -->
					<a href="${contextRoot}/cart/add/${product.id}/product"
						class="btn btn-success"><i class="fa fa-fw fa-shopping-cart"></i>
						Add to Cart </a>

				</c:otherwise>
			</c:choose>


			<!-- Back button -->
			<a href="${contextRoot}/show/all/products" class="btn btn-success">Back</a>

		</div>
	</div>

</div>