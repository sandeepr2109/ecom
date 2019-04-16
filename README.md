# ecom
@Author : Sandeep R

used postgres sql for this project, please execute the following queries

create table ecom.public.item (item_id int primary key,item_name varchar,quantity int,allocated int);
create table ecom.public.oder (order_id int primary key,email_id varchar);
create table ecom.public.order_details (order_detail_id int primary key,item_id int,item_name varchar,quantity int,allocated int);


insert into ecom.public.item values(1,'Phone',15,0);
insert into ecom.public.item values(2,'Laptop',15,0);
insert into ecom.public.item values(3,'Ear phones',15,0);
insert into ecom.public.item values(4,'TV',15,0);
insert into ecom.public.item values(5,'AC',15,0);

---------------------------------------------------------------------------------
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
---------------------------------------------------------------------------------------------

Order item

http://localhost:8080/OrderItem/
Body : { 
"emailId" : "sandeepr@gmail.com",
"itemId" : 1,
"itemName" : "Phone",
"quantity" : 5
}

Order successful

if Quantity is more than available then order unsuccessful

-------------------------------------------------------------------------------
Cancel Order

http://localhost:8080/CancelOrder/

body : {
"orderDetailId" :1,
"allocated" :5,
"itemId" : 1,
"itemName" : "Phone",
"quantity" : 5
}

Result : Cancel successful

---------------------------------------------------------------------------

update Order

http://localhost:8080/UpdateOrder/

{
"orderDetailId" :1,
"allocated" :4,
"itemId" : 1,
"itemName" : "Phone",
"quantity" : 4
}

Update successful

if update quantity more than available then update unsuccessful

-------------------------------------------------------------------------------

