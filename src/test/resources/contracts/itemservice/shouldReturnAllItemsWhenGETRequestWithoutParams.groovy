package itemservice
import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("When a GET request without params, all the items are returned")
    request {
        method 'GET'
        url '/'
        headers {
            header('Content-Type', 'application/json;charset=UTF-8')
        }
    }
    response {
        status 200
        body ("""
        [
            {
                "name": "Banana",
                "price": 550,
                "id": 1
            },
            {
                "name": "Apple",
                "price": 700,
                "id": 2
            },
            {
                "name": "Strawberry",
                "price": 4000,
                "id": 3
            },
            {
                "name": "Peach",
                "price": 5000,
                "id": 4
            },
            {
                "name": "Water mellon",
                "price": 9000,
                "id": 5
            }
        ]
        """)
        headers {
            header('Content-Type', 'application/json;charset=UTF-8')
        }
    }

}