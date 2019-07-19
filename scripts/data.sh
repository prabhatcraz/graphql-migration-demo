#!/usr/bin/env bash
curl -s -X POST -H "Content-type: application/json" http://localhost:8080/beer -d '
    {
        "name"  : "Heineken",
        "type"  : "Lager",
        "price" : 3.2
    }
'  | jq .

curl -s -X POST -H "Content-type: application/json" http://localhost:8080/beer -d '
    {
        "name"  : "Erdinger",
        "type"  : "wheat",
        "price" : 4.0
    }
'  | jq .

curl -s -X POST -H "Content-type: application/json" http://localhost:8080/beer -d '
    {
        "name"  : "Budweiser",
        "type"  : "pale",
        "price" : 3.0
    }
'  | jq .

curl -s -X POST -H "Content-type: application/json" http://localhost:8080/beer -d '
    {
        "name"  : "Guinness",
        "type"  : "stout",
        "price" : 3.6
    }
'  | jq .

curl -s -X PUT -H "Content-type: application/json" http://localhost:8080/beer -d '
    {
        "name"  : "GuinnessZZZZ",
        "type"  : "stout",
        "price" : 3.6
    }
'  | jq .

curl -s -X GET http://localhost:8080/beers | jq .

curl -s -X GET http://localhost:8080/beer/1 | jq .


curl -s -X POST -H "Content-type: application/json" http://localhost:8080/data  -d '
    {
        getAll {
            id
            name
            type
            price
        }
    }
' | jq .

curl -s -X POST -H "Content-type: application/json" http://localhost:8080/data  -d '
    {
        get(id:"1") {
            id
            name
            type
            price
        }
    }
' | jq .

curl -s -X POST -H "Content-type: application/json" http://localhost:8080/data  -d '
    mutation {
    	create(
    	    beer: {
    	        name: "XYZ",
    	        type: "pale",
    	        price: 4.2
    	    }
    	) {
    	    id
    	    name
    	    type
    	    price
    	}
    }
' | jq .

curl -s -X POST -H "Content-type: application/json" http://localhost:8080/data  -d '
    mutation {
    	delete(id: "3")
    }
' | jq .

curl -s -X POST -H "Content-type: application/json" http://localhost:8080/data  -d '
    mutation {
    	update(
    	    id: "4"
    	    beer: {
    	        name: "XYZ",
    	        type: "pale",
    	        price: 4.2
    	    }
    	) {
    	    id
    	    name
    	    type
    	    price
    	}
    }
' | jq .
