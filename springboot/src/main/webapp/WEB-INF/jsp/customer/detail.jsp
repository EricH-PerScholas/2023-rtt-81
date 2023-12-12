<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>


<section>
    <div class="bg-light2 pt-5 pb-5">
        <div class="row">
            <div class="col-12 text-center">
                <h1 class="m-0">Customer Detail</h1>
            </div>
        </div>
    </div>
</section>


<section>
    <table>
        <div class="card" style="width: 18rem;">
            <img class="card-img-top" style="max-height:200px" src="${customer.imageUrl}" alt="Card image cap">
            <div class="card-body">
                <h5 class="card-title"><a href="/customer/detail?id=${customer.id}">${customer.firstName} ${customer.lastName}</a></h5>
                <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                <p class="card-test">$19.99</p>
                <a href="/customer/detail?id=${customer.id}" class="btn btn-primary">Customer Details</a>
            </div>
        </div>

    </table>
</section>




<jsp:include page="../include/footer.jsp"/>