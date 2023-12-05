--
-- PostgreSQL database dump
--

-- Dumped from database version 16.0
-- Dumped by pg_dump version 16.0

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

--
-- Name: webshop; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA webshop;


ALTER SCHEMA webshop OWNER TO postgres;

--
-- Name: category; Type: TYPE; Schema: webshop; Owner: postgres
--

CREATE TYPE webshop.category AS ENUM (
    'Apparel',
    'Footwear',
    'Sportswear',
    'Traditional',
    'Formal Wear',
    'Accessories',
    'Watches & Jewelry',
    'Luggage',
    'Cosmetics'
);


ALTER TYPE webshop.category OWNER TO postgres;

--
-- Name: TYPE category; Type: COMMENT; Schema: webshop; Owner: postgres
--

COMMENT ON TYPE webshop.category IS 'Sizes for US, UK and EU';


--
-- Name: gender; Type: TYPE; Schema: webshop; Owner: postgres
--

CREATE TYPE webshop.gender AS ENUM (
    'male',
    'female',
    'unisex'
);


ALTER TYPE webshop.gender OWNER TO postgres;

--
-- Name: TYPE gender; Type: COMMENT; Schema: webshop; Owner: postgres
--

COMMENT ON TYPE webshop.gender IS 'Gender of customer or clothes';


--
-- Name: CAST (character varying AS webshop.gender); Type: CAST; Schema: -; Owner: -
--

CREATE CAST (character varying AS webshop.gender) WITH INOUT AS IMPLICIT;


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: public_table; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.public_table (
);


ALTER TABLE public.public_table OWNER TO postgres;

--
-- Name: address; Type: TABLE; Schema: webshop; Owner: postgres
--

CREATE TABLE webshop.address (
    id integer NOT NULL,
    customerid integer,
    firstname text,
    lastname text,
    address1 text,
    address2 text,
    city text,
    zip text,
    created timestamp with time zone DEFAULT now(),
    updated timestamp with time zone
);


ALTER TABLE webshop.address OWNER TO postgres;

--
-- Name: TABLE address; Type: COMMENT; Schema: webshop; Owner: postgres
--

COMMENT ON TABLE webshop.address IS 'Addresses for receipts and shipping';


--
-- Name: address_id_seq; Type: SEQUENCE; Schema: webshop; Owner: postgres
--

CREATE SEQUENCE webshop.address_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE webshop.address_id_seq OWNER TO postgres;

--
-- Name: address_id_seq; Type: SEQUENCE OWNED BY; Schema: webshop; Owner: postgres
--

ALTER SEQUENCE webshop.address_id_seq OWNED BY webshop.address.id;


--
-- Name: articles; Type: TABLE; Schema: webshop; Owner: postgres
--

CREATE TABLE webshop.articles (
    id integer NOT NULL,
    productid integer,
    ean text,
    colorid integer,
    size integer,
    description text,
    originalprice money,
    reducedprice money,
    taxrate numeric,
    discountinpercent integer,
    currentlyactive boolean,
    created timestamp with time zone DEFAULT now(),
    updated timestamp with time zone
);


ALTER TABLE webshop.articles OWNER TO postgres;

--
-- Name: TABLE articles; Type: COMMENT; Schema: webshop; Owner: postgres
--

COMMENT ON TABLE webshop.articles IS 'Instance of a product with a size, color and price';


--
-- Name: articles_id_seq; Type: SEQUENCE; Schema: webshop; Owner: postgres
--

CREATE SEQUENCE webshop.articles_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE webshop.articles_id_seq OWNER TO postgres;

--
-- Name: articles_id_seq; Type: SEQUENCE OWNED BY; Schema: webshop; Owner: postgres
--

ALTER SEQUENCE webshop.articles_id_seq OWNED BY webshop.articles.id;


--
-- Name: colors; Type: TABLE; Schema: webshop; Owner: postgres
--

CREATE TABLE webshop.colors (
    id integer NOT NULL,
    name text,
    rgb text
);


ALTER TABLE webshop.colors OWNER TO postgres;

--
-- Name: TABLE colors; Type: COMMENT; Schema: webshop; Owner: postgres
--

COMMENT ON TABLE webshop.colors IS 'Colors with name and rgb value';


--
-- Name: colors_id_seq; Type: SEQUENCE; Schema: webshop; Owner: postgres
--

CREATE SEQUENCE webshop.colors_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE webshop.colors_id_seq OWNER TO postgres;

--
-- Name: colors_id_seq; Type: SEQUENCE OWNED BY; Schema: webshop; Owner: postgres
--

ALTER SEQUENCE webshop.colors_id_seq OWNED BY webshop.colors.id;


--
-- Name: customer; Type: TABLE; Schema: webshop; Owner: postgres
--

CREATE TABLE webshop.customer (
    id integer NOT NULL,
    firstname text,
    lastname text,
    gender webshop.gender,
    email text,
    dateofbirth date,
    currentaddressid integer,
    created timestamp with time zone DEFAULT now(),
    updated timestamp with time zone
);


ALTER TABLE webshop.customer OWNER TO postgres;

--
-- Name: TABLE customer; Type: COMMENT; Schema: webshop; Owner: postgres
--

COMMENT ON TABLE webshop.customer IS 'Basic customer data';


--
-- Name: customer_id_seq1; Type: SEQUENCE; Schema: webshop; Owner: postgres
--

CREATE SEQUENCE webshop.customer_id_seq1
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE webshop.customer_id_seq1 OWNER TO postgres;

--
-- Name: customer_id_seq1; Type: SEQUENCE OWNED BY; Schema: webshop; Owner: postgres
--

ALTER SEQUENCE webshop.customer_id_seq1 OWNED BY webshop.customer.id;


--
-- Name: labels; Type: TABLE; Schema: webshop; Owner: postgres
--

CREATE TABLE webshop.labels (
    id integer NOT NULL,
    name text,
    slugname text,
    icon bytea
);


ALTER TABLE webshop.labels OWNER TO postgres;

--
-- Name: TABLE labels; Type: COMMENT; Schema: webshop; Owner: postgres
--

COMMENT ON TABLE webshop.labels IS 'Brands / labels';


--
-- Name: labels_id_seq; Type: SEQUENCE; Schema: webshop; Owner: postgres
--

CREATE SEQUENCE webshop.labels_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE webshop.labels_id_seq OWNER TO postgres;

--
-- Name: labels_id_seq; Type: SEQUENCE OWNED BY; Schema: webshop; Owner: postgres
--

ALTER SEQUENCE webshop.labels_id_seq OWNED BY webshop.labels.id;


--
-- Name: order; Type: TABLE; Schema: webshop; Owner: postgres
--

CREATE TABLE webshop."order" (
    id integer NOT NULL,
    customer integer,
    ordertimestamp timestamp with time zone DEFAULT now(),
    shippingaddressid integer,
    total money,
    shippingcost money,
    created timestamp with time zone DEFAULT now(),
    updated timestamp with time zone
);


ALTER TABLE webshop."order" OWNER TO postgres;

--
-- Name: TABLE "order"; Type: COMMENT; Schema: webshop; Owner: postgres
--

COMMENT ON TABLE webshop."order" IS 'Metadata for an order, see order_positions as well';


--
-- Name: order_id_seq; Type: SEQUENCE; Schema: webshop; Owner: postgres
--

CREATE SEQUENCE webshop.order_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE webshop.order_id_seq OWNER TO postgres;

--
-- Name: order_id_seq; Type: SEQUENCE OWNED BY; Schema: webshop; Owner: postgres
--

ALTER SEQUENCE webshop.order_id_seq OWNED BY webshop."order".id;


--
-- Name: order_positions; Type: TABLE; Schema: webshop; Owner: postgres
--

CREATE TABLE webshop.order_positions (
    id integer NOT NULL,
    orderid integer,
    articleid integer,
    amount smallint,
    price money,
    created timestamp with time zone DEFAULT now(),
    updated timestamp with time zone
);


ALTER TABLE webshop.order_positions OWNER TO postgres;

--
-- Name: TABLE order_positions; Type: COMMENT; Schema: webshop; Owner: postgres
--

COMMENT ON TABLE webshop.order_positions IS 'Articles that are contained in an order';


--
-- Name: order_positions_id_seq; Type: SEQUENCE; Schema: webshop; Owner: postgres
--

CREATE SEQUENCE webshop.order_positions_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE webshop.order_positions_id_seq OWNER TO postgres;

--
-- Name: order_positions_id_seq; Type: SEQUENCE OWNED BY; Schema: webshop; Owner: postgres
--

ALTER SEQUENCE webshop.order_positions_id_seq OWNED BY webshop.order_positions.id;


--
-- Name: products; Type: TABLE; Schema: webshop; Owner: postgres
--

CREATE TABLE webshop.products (
    id integer NOT NULL,
    name text,
    labelid integer,
    category webshop.category,
    gender webshop.gender,
    currentlyactive boolean,
    created timestamp with time zone DEFAULT now(),
    updated timestamp with time zone
);


ALTER TABLE webshop.products OWNER TO postgres;

--
-- Name: TABLE products; Type: COMMENT; Schema: webshop; Owner: postgres
--

COMMENT ON TABLE webshop.products IS 'Groups articles (differing in sizes/color)';


--
-- Name: products_id_seq; Type: SEQUENCE; Schema: webshop; Owner: postgres
--

CREATE SEQUENCE webshop.products_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE webshop.products_id_seq OWNER TO postgres;

--
-- Name: products_id_seq; Type: SEQUENCE OWNED BY; Schema: webshop; Owner: postgres
--

ALTER SEQUENCE webshop.products_id_seq OWNED BY webshop.products.id;


--
-- Name: sizes; Type: TABLE; Schema: webshop; Owner: postgres
--

CREATE TABLE webshop.sizes (
    id integer NOT NULL,
    gender webshop.gender,
    category webshop.category,
    size text,
    size_us int4range,
    size_uk int4range,
    size_eu int4range
);


ALTER TABLE webshop.sizes OWNER TO postgres;

--
-- Name: TABLE sizes; Type: COMMENT; Schema: webshop; Owner: postgres
--

COMMENT ON TABLE webshop.sizes IS 'Colors with name and rgb value';


--
-- Name: sizes_id_seq; Type: SEQUENCE; Schema: webshop; Owner: postgres
--

CREATE SEQUENCE webshop.sizes_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE webshop.sizes_id_seq OWNER TO postgres;

--
-- Name: sizes_id_seq; Type: SEQUENCE OWNED BY; Schema: webshop; Owner: postgres
--

ALTER SEQUENCE webshop.sizes_id_seq OWNED BY webshop.sizes.id;


--
-- Name: stock; Type: TABLE; Schema: webshop; Owner: postgres
--

CREATE TABLE webshop.stock (
    id integer NOT NULL,
    articleid integer,
    count integer,
    created timestamp with time zone DEFAULT now(),
    updated timestamp with time zone
);


ALTER TABLE webshop.stock OWNER TO postgres;

--
-- Name: TABLE stock; Type: COMMENT; Schema: webshop; Owner: postgres
--

COMMENT ON TABLE webshop.stock IS 'Amount of articles on stock';


--
-- Name: stock_id_seq; Type: SEQUENCE; Schema: webshop; Owner: postgres
--

CREATE SEQUENCE webshop.stock_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE webshop.stock_id_seq OWNER TO postgres;

--
-- Name: stock_id_seq; Type: SEQUENCE OWNED BY; Schema: webshop; Owner: postgres
--

ALTER SEQUENCE webshop.stock_id_seq OWNED BY webshop.stock.id;


--
-- Name: address id; Type: DEFAULT; Schema: webshop; Owner: postgres
--

ALTER TABLE ONLY webshop.address ALTER COLUMN id SET DEFAULT nextval('webshop.address_id_seq'::regclass);


--
-- Name: articles id; Type: DEFAULT; Schema: webshop; Owner: postgres
--

ALTER TABLE ONLY webshop.articles ALTER COLUMN id SET DEFAULT nextval('webshop.articles_id_seq'::regclass);


--
-- Name: colors id; Type: DEFAULT; Schema: webshop; Owner: postgres
--

ALTER TABLE ONLY webshop.colors ALTER COLUMN id SET DEFAULT nextval('webshop.colors_id_seq'::regclass);


--
-- Name: customer id; Type: DEFAULT; Schema: webshop; Owner: postgres
--

ALTER TABLE ONLY webshop.customer ALTER COLUMN id SET DEFAULT nextval('webshop.customer_id_seq1'::regclass);


--
-- Name: labels id; Type: DEFAULT; Schema: webshop; Owner: postgres
--

ALTER TABLE ONLY webshop.labels ALTER COLUMN id SET DEFAULT nextval('webshop.labels_id_seq'::regclass);


--
-- Name: order id; Type: DEFAULT; Schema: webshop; Owner: postgres
--

ALTER TABLE ONLY webshop."order" ALTER COLUMN id SET DEFAULT nextval('webshop.order_id_seq'::regclass);


--
-- Name: order_positions id; Type: DEFAULT; Schema: webshop; Owner: postgres
--

ALTER TABLE ONLY webshop.order_positions ALTER COLUMN id SET DEFAULT nextval('webshop.order_positions_id_seq'::regclass);


--
-- Name: products id; Type: DEFAULT; Schema: webshop; Owner: postgres
--

ALTER TABLE ONLY webshop.products ALTER COLUMN id SET DEFAULT nextval('webshop.products_id_seq'::regclass);


--
-- Name: sizes id; Type: DEFAULT; Schema: webshop; Owner: postgres
--

ALTER TABLE ONLY webshop.sizes ALTER COLUMN id SET DEFAULT nextval('webshop.sizes_id_seq'::regclass);


--
-- Name: stock id; Type: DEFAULT; Schema: webshop; Owner: postgres
--

ALTER TABLE ONLY webshop.stock ALTER COLUMN id SET DEFAULT nextval('webshop.stock_id_seq'::regclass);


--
-- Name: address address_pkey; Type: CONSTRAINT; Schema: webshop; Owner: postgres
--

ALTER TABLE ONLY webshop.address
    ADD CONSTRAINT address_pkey PRIMARY KEY (id);


--
-- Name: articles articles_pkey; Type: CONSTRAINT; Schema: webshop; Owner: postgres
--

ALTER TABLE ONLY webshop.articles
    ADD CONSTRAINT articles_pkey PRIMARY KEY (id);


--
-- Name: colors colors_pkey; Type: CONSTRAINT; Schema: webshop; Owner: postgres
--

ALTER TABLE ONLY webshop.colors
    ADD CONSTRAINT colors_pkey PRIMARY KEY (id);


--
-- Name: customer customer_pkey1; Type: CONSTRAINT; Schema: webshop; Owner: postgres
--

ALTER TABLE ONLY webshop.customer
    ADD CONSTRAINT customer_pkey1 PRIMARY KEY (id);


--
-- Name: labels labels_pkey; Type: CONSTRAINT; Schema: webshop; Owner: postgres
--

ALTER TABLE ONLY webshop.labels
    ADD CONSTRAINT labels_pkey PRIMARY KEY (id);


--
-- Name: order order_pkey; Type: CONSTRAINT; Schema: webshop; Owner: postgres
--

ALTER TABLE ONLY webshop."order"
    ADD CONSTRAINT order_pkey PRIMARY KEY (id);


--
-- Name: order_positions order_positions_pkey; Type: CONSTRAINT; Schema: webshop; Owner: postgres
--

ALTER TABLE ONLY webshop.order_positions
    ADD CONSTRAINT order_positions_pkey PRIMARY KEY (id);


--
-- Name: products products_pkey; Type: CONSTRAINT; Schema: webshop; Owner: postgres
--

ALTER TABLE ONLY webshop.products
    ADD CONSTRAINT products_pkey PRIMARY KEY (id);


--
-- Name: sizes sizes_pkey; Type: CONSTRAINT; Schema: webshop; Owner: postgres
--

ALTER TABLE ONLY webshop.sizes
    ADD CONSTRAINT sizes_pkey PRIMARY KEY (id);


--
-- Name: stock stock_pkey; Type: CONSTRAINT; Schema: webshop; Owner: postgres
--

ALTER TABLE ONLY webshop.stock
    ADD CONSTRAINT stock_pkey PRIMARY KEY (id);


--
-- Name: articles articles_colorid_fkey; Type: FK CONSTRAINT; Schema: webshop; Owner: postgres
--

ALTER TABLE ONLY webshop.articles
    ADD CONSTRAINT articles_colorid_fkey FOREIGN KEY (colorid) REFERENCES webshop.colors(id);


--
-- Name: order_positions order_positions_articleid_fkey; Type: FK CONSTRAINT; Schema: webshop; Owner: postgres
--

ALTER TABLE ONLY webshop.order_positions
    ADD CONSTRAINT order_positions_articleid_fkey FOREIGN KEY (articleid) REFERENCES webshop.articles(id);


--
-- Name: order_positions order_positions_orderid_fkey; Type: FK CONSTRAINT; Schema: webshop; Owner: postgres
--

ALTER TABLE ONLY webshop.order_positions
    ADD CONSTRAINT order_positions_orderid_fkey FOREIGN KEY (orderid) REFERENCES webshop."order"(id);


--
-- Name: order order_shippingaddressid_fkey; Type: FK CONSTRAINT; Schema: webshop; Owner: postgres
--

ALTER TABLE ONLY webshop."order"
    ADD CONSTRAINT order_shippingaddressid_fkey FOREIGN KEY (shippingaddressid) REFERENCES webshop.address(id);


--
-- Name: stock stock_articleid_fkey; Type: FK CONSTRAINT; Schema: webshop; Owner: postgres
--

ALTER TABLE ONLY webshop.stock
    ADD CONSTRAINT stock_articleid_fkey FOREIGN KEY (articleid) REFERENCES webshop.articles(id);


--
-- PostgreSQL database dump complete
--

