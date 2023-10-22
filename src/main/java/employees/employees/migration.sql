--
-- PostgreSQL database dump
--

-- Dumped from database version 15.3
-- Dumped by pg_dump version 15.3

-- Started on 2023-10-12 13:25:58

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE employees;
--
-- TOC entry 3335 (class 1262 OID 33240)
-- Name: employees; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE employees WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_United States.1252';


ALTER DATABASE employees OWNER TO postgres;

\connect employees

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 216 (class 1259 OID 37181)
-- Name: employee; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employee (
    phone_number character varying(255),
    id bigint NOT NULL,
    email character varying(255),
    f_name character varying(255),
    job_title character varying(255),
    l_name character varying(255),
    dob date
);


ALTER TABLE public.employee OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 37188)
-- Name: employee_employees; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employee_employees (
    employee_id bigint NOT NULL,
    employees_id bigint NOT NULL
);


ALTER TABLE public.employee_employees OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 33248)
-- Name: employee_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.employee_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.employee_seq OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 37180)
-- Name: employee_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.employee_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.employee_sequence OWNER TO postgres;

--
-- TOC entry 3328 (class 0 OID 37181)
-- Dependencies: 216
-- Data for Name: employee; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.employee (phone_number, id, email, f_name, job_title, l_name, dob) VALUES ('+998994518864', 30, 'rashidbekraximov@gmail.com', 'Rashidbek', 'programmer', 'Raximov', NULL);
INSERT INTO public.employee (phone_number, id, email, f_name, job_title, l_name, dob) VALUES ('+998919132740', 36, 'jumaniyozibragimov@gmail.com', 'Jumaniyoz', 'pupil', 'Ibragimov', '2004-02-24');


--
-- TOC entry 3329 (class 0 OID 37188)
-- Dependencies: 217
-- Data for Name: employee_employees; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.employee_employees (employee_id, employees_id) VALUES (36, 36);


--
-- TOC entry 3336 (class 0 OID 0)
-- Dependencies: 214
-- Name: employee_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.employee_seq', 1, false);


--
-- TOC entry 3337 (class 0 OID 0)
-- Dependencies: 215
-- Name: employee_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.employee_sequence', 37, true);


--
-- TOC entry 3181 (class 2606 OID 37192)
-- Name: employee_employees employee_employees_employees_id_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee_employees
    ADD CONSTRAINT employee_employees_employees_id_key UNIQUE (employees_id);


--
-- TOC entry 3179 (class 2606 OID 37187)
-- Name: employee employee_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT employee_pkey PRIMARY KEY (id);


--
-- TOC entry 3182 (class 2606 OID 37193)
-- Name: employee_employees fk3notb1dgf7f4fn773uc370tn5; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee_employees
    ADD CONSTRAINT fk3notb1dgf7f4fn773uc370tn5 FOREIGN KEY (employees_id) REFERENCES public.employee(id);


--
-- TOC entry 3183 (class 2606 OID 37198)
-- Name: employee_employees fknr6s0oeqpa25a2l83tyg5c4b0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee_employees
    ADD CONSTRAINT fknr6s0oeqpa25a2l83tyg5c4b0 FOREIGN KEY (employee_id) REFERENCES public.employee(id);


-- Completed on 2023-10-12 13:25:58

--
-- PostgreSQL database dump complete
--

