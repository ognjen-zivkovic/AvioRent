INSERT INTO plane(
	plane_id,  max_speed, model, price, range, seats)
	VALUES (501, 2500, 'Sputnik', 50000, 5000, 25);


INSERT INTO plane(
	plane_id,  max_speed, model, price, range, seats)
	VALUES (502, 1000, 'Cesna', 25000, 5500, 2);



INSERT INTO plane(
	plane_id,  max_speed, model, price, range, seats)
	VALUES (503,  5000, 'F117', 10000, 6230, 3);


INSERT INTO plane(
	plane_id,  max_speed, model, price, range, seats)
	VALUES (499, 1000, 'Cesna', 25000, 5500, 2);

	INSERT INTO plane(
	plane_id,  max_speed, model, price, range, seats)
	VALUES (498, 1000, 'Cesna', 25000, 5500, 2);

	INSERT INTO plane(
	plane_id,  max_speed, model, price, range, seats)
	VALUES (497, 1000, 'Cesna', 25000, 5500, 2);
	INSERT INTO plane(
	plane_id,  max_speed, model, price, range, seats)
	VALUES (496, 1000, 'Cesna', 25000, 5500, 2);
	INSERT INTO plane(
	plane_id,  max_speed, model, price, range, seats)
	VALUES (495, 1000, 'Cesna', 25000, 5500, 2);
	INSERT INTO plane(
	plane_id,  max_speed, model, price, range, seats)
	VALUES (494, 1000, 'Cesna', 25000, 5500, 2);
	INSERT INTO plane(
	plane_id,  max_speed, model, price, range, seats)
	VALUES (493, 1000, 'Cesna', 25000, 5500, 2);
	INSERT INTO plane(
	plane_id,  max_speed, model, price, range, seats)
	VALUES (492, 1000, 'Cesna', 25000, 5500, 2);
	INSERT INTO plane(
	plane_id,  max_speed, model, price, range, seats)
	VALUES (491, 1000, 'Cesna', 25000, 5500, 2);
























	INSERT INTO client(
	client_id, email, password, phone, user_name, roles)
	VALUES (501, 'boki-ilic@gmail.com', '123456', '063/456-789', 'boki', 'ROLE_ADMIN');


	INSERT INTO client(
	client_id, email, password, phone, user_name, roles)
	VALUES (502, 'boki-ilic32@gmail.com', '56452', '063/123-312', 'boki32', 'admin');

	INSERT INTO client(
	client_id, email, password, phone, user_name, roles)
	VALUES (503, 'ilija_bojanic@yahoo.com', '123', '063/754-312', 'Ica', 'user');


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
	VALUES (501, '2020-06-01', '2020-06-30', '2020-06-11', 'BEG', 'HMD', true, 2, 501, 501, 501);

		INSERT INTO rent(
	rent_id, created_at, date_end, date_start, destination_from, destination_to, is_round_trip, passengers, client_id, plane_id, rent_status_id)
	VALUES (502, '2020-07-01', '2020-08-01', '2020-07-15', 'BEG', 'DME', false, 3, 502, 502, 503);


		INSERT INTO rent(
	rent_id, created_at, date_end, date_start, destination_from, destination_to, is_round_trip, passengers, client_id, plane_id, rent_status_id)

	VALUES (503, '2020-10-01', '2020-12-01', '2020-11-15', 'BEG', 'FIH', false, 3, 503, 503, 502);



	VALUES (503, '2020-10-01', '2020-06-16', '2020-06-1', 'BEG', 'FIH', false, 3, 503, 503, 502);


INSERT INTO plane_image(
	plane_image_id, image_path, plane_id)
	VALUES (501, '/upload/static/planeImages/prviAvion.jpg', 501);
	INSERT INTO plane_image(
	plane_image_id, image_path, plane_id)
	VALUES (504, '/upload/static/planeImages/drugiAvion.jpg', 501);
	INSERT INTO plane_image(
	plane_image_id, image_path, plane_id)
	VALUES (502, '/upload/static/planeImages/treciAvion.jpg', 502);
		INSERT INTO plane_image(
	plane_image_id, image_path, plane_id)
	VALUES (503, '/upload/static/planeImages/cetvrtiAvion.jpg', 503);

