INSERT INTO plane(
	plane_id, image, max_speed, model, price, range, seats)
	VALUES (1, 'img.jpg', 2500, 'Sputnik', 50000, 5000, 25);


INSERT INTO plane(
	plane_id, image, max_speed, model, price, range, seats)
	VALUES (2, 'img2.jpg', 1000, 'Cesna', 25000, 5500, 2);



INSERT INTO plane(
	plane_id, image, max_speed, model, price, range, seats)
	VALUES (3, 'img3.jpg', 5000, 'F117', 10000, 6230, 3);


	INSERT INTO client(
	client_id, email, password, phone, user_name)
	VALUES (1, 'boki-ilic@gmail.com', '123456', '063/456-789', 'boki');


	INSERT INTO client(
	client_id, email, password, phone, user_name)
	VALUES (2, 'boki-ilic32@gmail.com', '56452', '063/123-312', 'boki32');

	INSERT INTO client(
	client_id, email, password, phone, user_name)
	VALUES (3, 'ilija_bojanic@yahoo.com', '123', '063/754-312', 'Ica');

	INSERT INTO crew_member_type(
	crew_member_type_id, type)
	VALUES (1, 'Pilot');

		INSERT INTO crew_member_type(
	crew_member_type_id, type)
	VALUES (2, 'Co-pilot');

	INSERT INTO crew_member_type(
	crew_member_type_id, type)
	VALUES (3, 'Flight attendant');

	INSERT INTO crew_member(
	crew_member_id, first_name, last_name, crew_member_type_id, plane_id)
	VALUES (1, 'Dusan', 'Vuckovic', 1, 1);

		INSERT INTO crew_member(
	crew_member_id, first_name, last_name, crew_member_type_id, plane_id)
	VALUES (2, 'Pilot', 'Dusan', 2, 2);

		INSERT INTO crew_member(
	crew_member_id, first_name, last_name, crew_member_type_id, plane_id)
	VALUES (3, 'Danilo', 'Stepanovic', 2, 3);

	INSERT INTO rent_status(
	rent_status_id, status)
	VALUES (1, 'Active');
	INSERT INTO rent_status(
	rent_status_id, status)
	VALUES (2, 'Pending');
	INSERT INTO rent_status(
	rent_status_id, status)
	VALUES (3, 'Confirmed');
	INSERT INTO rent_status(
	rent_status_id, status)
	VALUES (4, 'Canceled');


	INSERT INTO rent(
	rent_id, created_at, date_end, date_start, destination_from, destination_to, is_round_trip, passengers, client_id, plane_id, rent_status_id)
	VALUES (1, '2020-06-01', '2020-07-01', '2020-06-15', 'BEG', 'HMD', true, 2, 1, 1, 1);

		INSERT INTO rent(
	rent_id, created_at, date_end, date_start, destination_from, destination_to, is_round_trip, passengers, client_id, plane_id, rent_status_id)
	VALUES (2, '2020-07-01', '2020-08-01', '2020-07-15', 'BEG', 'DME', false, 3, 2, 2, 3);


		INSERT INTO rent(
	rent_id, created_at, date_end, date_start, destination_from, destination_to, is_round_trip, passengers, client_id, plane_id, rent_status_id)
	VALUES (3, '2020-10-01', '2020-12-01', '2020-11-15', 'BEG', 'FIH', false, 3, 3, 3, 2);
