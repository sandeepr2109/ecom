# ecom
List All Items
GET : http://localhost:8080/getAllItems
Result: [
    {
        "itemId": 1,
        "itemName": "Phone",
        "quantity": 15,
        "allocated": 0
    },
    {
        "itemId": 2,
        "itemName": "Laptop",
        "quantity": 15,
        "allocated": 0
    } ]

-------------------------------------------------------------------------------------------

List Item by ID
http://localhost:8080/getItem/{id}

GET : http://localhost:8080/getItem/2
Result:
	{
		"itemId": 2,
		"itemName": "Laptop",
		"quantity": 15,
		"allocated": 0
	}

-------------------------------------------------------------------------------------------

Add Item
Post: http://localhost:8080/AddItem/
Body: {"itemId":6,"itemName":"test","quantity":15,"allocated":0}

Result: Added Item Successfully

Tried to update existing item
Result: Item is Already Added


-------------------------------------------------------------------------------------------

Update Item
Put: http://localhost:8080/AddItem/
Body: {"itemId":6,"itemName":"test","quantity":15,"allocated":5}

Result: Updated Item Successfully

Tried to update non existing item
Result: No Item exists


-------------------------------------------------------------------------------------------

Delete Item
http://localhost:8080/DeleteItem/{id}

Delete: http://localhost:8080/DeleteItem/6
Result: Deleted Successfully
