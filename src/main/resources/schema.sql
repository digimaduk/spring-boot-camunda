create table customer_order(customer_order_id serial primary key)
create table customer_order_workflow(customer_order_workflow_id serial primary key, workflow_stage_id number, workflow_status_id number, assigned_to varchar(16), camunda_task_id nvarchar2(64), customer_order_id number)
