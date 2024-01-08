CREATE DATABASE dbtkb;
USE dbtkb;
CREATE TABLE roles (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL
);
INSERT INTO roles (name) VALUES ('admin');
INSERT INTO roles (name) VALUES ('user');
CREATE TABLE users(
    id INT PRIMARY KEY AUTO_INCREMENT,
    fullname VARCHAR(100) DEFAULT '',
    phone_number VARCHAR(10) NOT NULL UNIQUE,
    address VARCHAR(200) DEFAULT '',
    password VARCHAR(100) NOT NULL DEFAULT '',
    created_at DATETIME,
    updated_at DATETIME,
    is_active TINYINT(1) DEFAULT 1,
    role_id INT,
    FOREIGN KEY (role_id) REFERENCES roles(id)
);

-- Bảng đối tượng --
CREATE TABLE objectm(
    id INT PRIMARY KEY,
    name ENUM
        (
            'Đại học cao đẳng',
            'Cấp 3, trải nghiệm',
            'Giáo dục thường xuyên'
        )
);
INSERT INTO objectm (id, name) VALUES (0, 'Đại học cao đẳng');
INSERT INTO objectm (id, name) VALUES (1, 'Cấp 3, trải nghiệm');
INSERT INTO objectm (id, name) VALUES (2, 'Giáo dục thường xuyên');
-- Bảng khoa --
CREATE TABLE departments(
    id VARCHAR(10) PRIMARY KEY,
    name VARCHAR(255)
);
INSERT INTO departments (id, name) VALUES ('CT', 'Chính trị');
INSERT INTO departments (id, name) VALUES ('QS', 'Quân sự');

-- Bảng Thầy giáo
CREATE TABLE teachers(
    id VARCHAR(10) PRIMARY KEY,
    name VARCHAR(255),
    department_id VARCHAR(10),
    FOREIGN KEY (department_id) REFERENCES departments(id)
);
-- Bảng môn học --
CREATE TABLE subjects (
    id VARCHAR(10) PRIMARY KEY,
    name VARCHAR(255),
    department_id VARCHAR(10),
    FOREIGN KEY (department_id) REFERENCES departments(id),
    object_id INT,
    FOREIGN KEY (object_id) REFERENCES objectm(id)
);



-- Bảng bài học --
-- id, tên, độ ưu tiên, ghi chú, id môn học
CREATE TABLE lessons(
    id VARCHAR(10) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    priority TINYINT DEFAULT 0,
    note VARCHAR(255) DEFAULT '',
    subject_id VARCHAR(10),
    FOREIGN KEY (subject_id) REFERENCES subjects(id),
    type ENUM('TH', 'LT', 'KT')
);

USE dbtkb;
INSERT INTO subjects (id, name, department_id, object_id) VALUES ('CME 1001', 'Đường lối quốc phòng và an ninh của Đảng Cộng sản Việt Nam', 'CT', 0);
INSERT INTO subjects (id, name, department_id, object_id) VALUES ('CME 1002', 'Công tác Quốc phòng và An ninh', 'CT', 0);
INSERT INTO subjects (id, name, department_id, object_id) VALUES ('CME 1003', 'Quân sự chung', 'QS', 0);
INSERT INTO subjects (id, name, department_id, object_id) VALUES ('CME 1004', 'Kỹ thuật chiến đầu bộ binh và chiến thuật', 'QS', 0);


INSERT INTO lessons (id, name, priority, note, subject_id, type) VALUES ("A1", "Đối tượng, nhiệm vụ, phương pháp nghiên cứu môn học",1,"", 'CME 1001','LT');
INSERT INTO lessons (id, name, priority, note, subject_id, type) VALUES ("A2", "Quan điểm cơ bản của chủ nghĩa Mac-Lenin, tư tưởng Hồ Chính Minh về chiến tranh, quân đội và bảo vệ Tổ quốc",2,"", 'CME 1001','LT');
INSERT INTO lessons (id, name, priority, note, subject_id, type) VALUES ("A3", "Xây dựng nền quốc phòng toàn dân, an ninh nhân dân bảo vệ Tổ quốc Việt Nam xã hội chủ nghĩa",3,"", 'CME 1001','LT');
INSERT INTO lessons (id, name, priority, note, subject_id, type) VALUES ("A4", "Chiến tranh nhân dân bảo vệ tổ quốc Việt Nam xã hội chủ nghĩa",4,"", 'CME 1001','LT');
INSERT INTO lessons (id, name, priority, note, subject_id, type) VALUES ("A5", "Xây dựng lực lượng vũ trang nhân dân",5, "",'CME 1001','LT');
INSERT INTO lessons (id, name, priority, note, subject_id, type) VALUES ("A6", "Kết hợp phát triển kinh tế, xã hội với tăng cường quốc phòng, an ninh và đối ngoại",6,"", 'CME 1001','LT');
INSERT INTO lessons (id, name, priority, note, subject_id, type) VALUES ("A7", "Những vấn đề cơ bản về lịch sử nghệ thuật quân đội Việt Nam",7,"", 'CME 1001','LT');
INSERT INTO lessons (id, name, priority, note, subject_id, type) VALUES ("A8", "Xây dựng và bảo vệ chủ quyền biển đảo, biên giới quốc gia trong tình hình mới",8, "",'CME 1001','LT');
INSERT INTO lessons (id, name, priority, note, subject_id, type) VALUES ("A9", "Xây dựng lực lượng dân quân tự vệ, lực lượng dự bị động viên và động viên quốc phòng",9,"", 'CME 1001','LT');
INSERT INTO lessons (id, name, priority, note, subject_id, type) VALUES ("A10", "Xây dựng phong trào toàn dân bảo vệ an ninh Tổ quốc",10,"", 'CME 1001','LT');
INSERT INTO lessons (id, name, priority, note, subject_id, type) VALUES ("A11", "Những vấn đề cơ bản về bảo vệ an ninh quốc gia và bảo đảm trật tự an toàn xã hộ",11,"", 'CME 1001','LT');
INSERT INTO lessons (id, name, priority, note, subject_id, type) VALUES ("KTGK1", "Thi giữa kỳ môn A thi trong buổi học",12,"",'CME 1001','KT');
INSERT INTO lessons (id, name, priority, note, subject_id, type) VALUES ("Thi1", "Thi hết môn A",13,"", 'CME 1001','KT');

INSERT INTO lessons (id, name, priority, note, subject_id, type) VALUES ("B1","Phòng, chống chiến lược diễn biến hòa bình, bạo loạn lật đổ của các thế lực thù địch đối với các mạng Việt Nam",1,"", 'CME 1002','LT');
INSERT INTO lessons (id, name, priority, note, subject_id, type) VALUES ("B2","Một số nội dung cơ bản về dân tộc, tôn giáo, đấu tranh phòng chống các thế lực thù địch lợi dụng vấn đề về dân tộc, tôn giáo chống phá cách mạng Việt Nam",2,"", 'CME 1002','LT');
INSERT INTO lessons (id, name, priority, note, subject_id, type) VALUES ("B3","Phòng, chống vi phạm pháp luật về bảo vệ môi trường",3,"", 'CME 1002','LT');
INSERT INTO lessons (id, name, priority, note, subject_id, type) VALUES ("B4","Phòng, chống vi phạm pháp luật về bảo đảm trật tự an toàn giao thông",4,"", 'CME 1002','LT');
INSERT INTO lessons (id, name, priority, note, subject_id, type) VALUES ("B5","Phòng, chống một số loại tội phạm xâm hại danh dự, nhân phẩm của người khác",5,"", 'CME 1002','LT');
INSERT INTO lessons (id, name, priority, note, subject_id, type) VALUES ("B6","An toàn thông tin và phòng chống vi phạm pháp luật trên không gian mạng",6,"", 'CME 1002','LT');
INSERT INTO lessons (id, name, priority, note, subject_id, type) VALUES ("B7","An ninh phi truyền thống và các mối đe doạn an ninh phi truyền thông ở Việt Nam",7,"", 'CME 1002','LT');
INSERT INTO lessons (id, name, priority, note, subject_id, type) VALUES ("KTGK2","Thi giữa môn B thi trong buổi học",8,"", 'CME 1002','KT');
INSERT INTO lessons (id, name, priority, note, subject_id, type) VALUES ("Thi2","Thi hết môn B",9,"", 'CME 1002','KT');

INSERT INTO lessons (id, name, priority, note, subject_id, type) VALUES ("C1","Chế độ làm việc, sinh hoạt, học tập và quy định sắp xếp bố trí trật tự nội vụ vệ sinh doanh trại", 1, "C1, C2 cùng 1 buổi", 'CME 1003','LT');
INSERT INTO lessons (id, name, priority, note, subject_id, type) VALUES ("C2","Hiểu biết chung về quân, binh chủng trong QĐNDVN", 2, "C1, C2 cùng 1 buổi", 'CME 1003','LT');
INSERT INTO lessons (id, name, priority, note, subject_id, type) VALUES ("C3","Đội ngũ từng người có súng", 3, "",'CME 1003','LT');
INSERT INTO lessons (id, name, priority, note, subject_id, type) VALUES ("C4","Đội ngũ đơn vị", 4, "",'CME 1003','LT');
INSERT INTO lessons (id, name, priority, note, subject_id, type) VALUES ("C5","Hiểu biết chung về bản đồ địa hình quân sự", 5, "", 'CME 1003','LT');
INSERT INTO lessons (id, name, priority, note, subject_id, type) VALUES ("C6","Phòng tránh địch tiến công bằng hỏa lực vũ khí công nghệ cao", 6, "", 'CME 1003','LT');
INSERT INTO lessons (id, name, priority, note, subject_id, type) VALUES ("C7","Ba môn quân sự phối hợp", 7, "Bài C7 phải học sau bài NLĐ và TB",'CME 1003','LT');
INSERT INTO lessons (id, name, priority, note, subject_id, type) VALUES ("Thi3","Thi hết môn 3", 8, "",'CME 1003','KT');

INSERT INTO lessons (id, name, priority, note, subject_id, type) VALUES ("D1","Kỹ thuật bắn súng tiểu niên AK",1, "D1, D2 học cùng 1 buổi", 'CME 1004',"LT");
INSERT INTO lessons (id, name, priority, note, subject_id, type) VALUES ("D2","Tính năng, cấu tạo và cách sử dụng một số loại lựu đạn",2, "D1, D2 học cùng 1 buổi", 'CME 1004',"LT");
INSERT INTO lessons (id, name, priority, note, subject_id, type) VALUES ("D3.1","Từng người trong chiến đấu tiến công",3, "Thao trường không thể học cùng lúc quá 5 bài D3.1", 'CME 1004',"TH");
INSERT INTO lessons (id, name, priority, note, subject_id, type) VALUES ("D3.2","Từng người trong chiến đấu tiến công",4, "", 'CME 1004',"TH");
INSERT INTO lessons (id, name, priority, note, subject_id, type) VALUES ("D3.3","Từng người trong chiến đấu tiến công",5, "", 'CME 1004',"TH");
INSERT INTO lessons (id, name, priority, note, subject_id, type) VALUES ("D4.1","Từng người trong chiến đấu phòng ngự",6, "", 'CME 1004',"TH");
INSERT INTO lessons (id, name, priority, note, subject_id, type) VALUES ("D4.2","Từng người trong chiến đấu phòng ngự",7, "", 'CME 1004',"TH");
INSERT INTO lessons (id, name, priority, note, subject_id, type) VALUES ("D5","Từng người làm nhiệm vụ canh gác",8, "", 'CME 1004',"TH");
INSERT INTO lessons (id, name, priority, note, subject_id, type) VALUES ("TB1","Thực hành tập bắn súng tiểu niên AK",9, "", 'CME 1004',"TH");
INSERT INTO lessons (id, name, priority, note, subject_id, type) VALUES ("TB2","Thực hành tập bắn súng tiểu niên AK",10, "", 'CME 1004',"TH");
INSERT INTO lessons (id, name, priority, note, subject_id, type) VALUES ("TB3","Thực hành tập bắn súng tiểu niên AK",11, "", 'CME 1004',"TH");
INSERT INTO lessons (id, name, priority, note, subject_id, type) VALUES ("TB4","Thực hành tập bắn súng tiểu niên AK",12, "", 'CME 1004',"TH");
INSERT INTO lessons (id, name, priority, note, subject_id, type) VALUES ("NLĐ","Thực hành ném Lựu đạn bài 1b",13, "", 'CME 1004',"TH");
INSERT INTO lessons (id, name, priority, note, subject_id, type) VALUES ("KTBS","Kiểm tra môn D sau khi học hết môn D",14, "", 'CME 1004',"KT");