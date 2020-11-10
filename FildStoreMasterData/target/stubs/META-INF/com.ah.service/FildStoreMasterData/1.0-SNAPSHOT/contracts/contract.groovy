import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "Testing GetModel End Point"
    request {
        method GET()
        url("/api/v1/service-template/model/101") {
        }
    }
    response {
        body(file("modelresponse.json"))
        status 200
    }
}