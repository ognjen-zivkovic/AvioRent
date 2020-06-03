INSERT INTO plane(
	plane_id, image, max_speed, model, price, range, seats)
	VALUES (501, 'img.jpg', 2500, 'Sputnik', 50000, 5000, 25);


INSERT INTO plane(
	plane_id, image, max_speed, model, price, range, seats)
	VALUES (502, 'img2.jpg', 1000, 'Cesna', 25000, 5500, 2);



INSERT INTO plane(
	plane_id, image, max_speed, model, price, range, seats)
	VALUES (503, 'img3.jpg', 5000, 'F117', 10000, 6230, 3);


	INSERT INTO client(
	client_id, email, password, phone, user_name)
	VALUES (501, 'boki-ilic@gmail.com', '123456', '063/456-789', 'boki');


	INSERT INTO client(
	client_id, email, password, phone, user_name)
	VALUES (502, 'boki-ilic32@gmail.com', '56452', '063/123-312', 'boki32');

	INSERT INTO client(
	client_id, email, password, phone, user_name)
	VALUES (503, 'ilija_bojanic@yahoo.com', '123', '063/754-312', 'Ica');

	INSERT INTO crew_member_type(
	crew_member_type_id, type)
	VALUES (501, 'Pilot');

		INSERT INTO crew_member_type(
	crew_member_type_id, type)
	VALUES (502, 'Co-pilot');

	INSERT INTO crew_member_type(
	crew_member_type_id, type)
	VALUES (503, 'Flight attendant');

	INSERT INTO crew_member(
	crew_member_id, first_name, last_name, crew_member_type_id, plane_id)
	VALUES (501, 'Dusan', 'Vuckovic', 501, 501);

		INSERT INTO crew_member(
	crew_member_id, first_name, last_name, crew_member_type_id, plane_id)
	VALUES (502, 'Pilot', 'Dusan', 502, 502);

		INSERT INTO crew_member(
	crew_member_id, first_name, last_name, crew_member_type_id, plane_id)
	VALUES (503, 'Danilo', 'Stepanovic', 502, 503);

	INSERT INTO rent_status(
	rent_status_id, status)
	VALUES (501, 'Active');
	INSERT INTO rent_status(
	rent_status_id, status)
	VALUES (502, 'Pending');
	INSERT INTO rent_status(
	rent_status_id, status)
	VALUES (503, 'Confirmed');
	INSERT INTO rent_status(
	rent_status_id, status)
	VALUES (504, 'Canceled');


	INSERT INTO rent(
	rent_id, created_at, date_end, date_start, destination_from, destination_to, is_round_trip, passengers, client_id, plane_id, rent_status_id)
	VALUES (501, '2020-06-01', '2020-07-01', '2020-06-15', 'BEG', 'HMD', true, 2, 501, 501, 501);

		INSERT INTO rent(
	rent_id, created_at, date_end, date_start, destination_from, destination_to, is_round_trip, passengers, client_id, plane_id, rent_status_id)
	VALUES (502, '2020-07-01', '2020-08-01', '2020-07-15', 'BEG', 'DME', false, 3, 502, 502, 503);


		INSERT INTO rent(
	rent_id, created_at, date_end, date_start, destination_from, destination_to, is_round_trip, passengers, client_id, plane_id, rent_status_id)
	VALUES (503, '2020-10-01', '2020-12-01', '2020-11-15', 'BEG', 'FIH', false, 3, 503, 503, 502);
