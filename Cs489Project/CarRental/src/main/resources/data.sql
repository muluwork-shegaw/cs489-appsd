INSERT INTO feedback (local_date_time, comment, customer_id, reservation_id, created_at, updated_at)
SELECT NOW()                                                AS local_date_time,
       CONCAT('Feedback for Reservation ', r.reservationID) AS comment,
       r.customer_id                                        AS customer_id,
       r.reservationID                                      AS reservation_id,
       NOW()                                                AS created_at,
       NOW()                                                AS updated_at
FROM reservation r
WHERE r.reservation_status = 'CONFIRMED';
