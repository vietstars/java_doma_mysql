select
	account.id as id
	, account.name as name
	, account.item_id as item_id
	, item.name as item_name
	, item.price as item_price
	, account.item_count as item_count
from
	account
	left outer join item on
		item.id = account.item_id