CREATE TABLE `blog` (
                        `id` int NOT NULL AUTO_INCREMENT,
                        `author` varchar(255) NOT NULL,
                        `articleTitle` varchar(255) NOT NULL,
                        `articleContent` longtext NOT NULL,
                        `articleCategories` varchar(255) NOT NULL,
                        `publishDate` varchar(255) NOT NULL,
                        `articleSummary` text NOT NULL,
                        `likes` int NOT NULL,
                        `collects` int NOT NULL,
                        `author_id` int DEFAULT NULL,
                        `readed` int DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb3;



INSERT INTO shixun_blog.blog (id, author, articleTitle, articleContent, articleCategories, publishDate, articleSummary, likes, collects, author_id, readed) VALUES (1, 'John Doe', 'Introduction to MySQL', 'MySQL is a popular open-source relational database management system...', 'Database', '2023-08-01', 'An overview of MySQL and its features...', 121, 35, null, null);
INSERT INTO shixun_blog.blog (id, author, articleTitle, articleContent, articleCategories, publishDate, articleSummary, likes, collects, author_id, readed) VALUES (2, 'Jane Smith', 'Web Development with HTML and CSS', 'Learn how to create stunning websites using HTML and CSS...', 'Web Development', '2023-07-25', 'A beginner-friendly guide to web development...', 98, 42, null, null);
INSERT INTO shixun_blog.blog (id, author, articleTitle, articleContent, articleCategories, publishDate, articleSummary, likes, collects, author_id, readed) VALUES (3, 'Alice Johnson', 'Python Programming Basics', 'Python is a versatile programming language known for its...', 'Programming', '2023-08-10', 'A primer on Python programming essentials...', 150, 60, null, null);
INSERT INTO shixun_blog.blog (id, author, articleTitle, articleContent, articleCategories, publishDate, articleSummary, likes, collects, author_id, readed) VALUES (4, 'Bob Williams', 'Artificial Intelligence Explained', 'Discover the world of AI and its applications in various...', 'Artificial Intelligence', '2023-08-05', 'An exploration of artificial intelligence and its significance...', 200, 75, null, null);
INSERT INTO shixun_blog.blog (id, author, articleTitle, articleContent, articleCategories, publishDate, articleSummary, likes, collects, author_id, readed) VALUES (5, 'Emily Brown', 'Healthy Cooking Tips', 'Learn how to prepare nutritious and delicious meals...', 'Cooking', '2023-07-20', 'Tips for cooking and eating healthily...', 75, 28, null, null);
INSERT INTO shixun_blog.blog (id, author, articleTitle, articleContent, articleCategories, publishDate, articleSummary, likes, collects, author_id, readed) VALUES (6, '张丽', 'Python 入门指南', 'Python 是一门多用途且适合初学者的编程语言...', '编程', '2023-08-18', 'Python 编程入门指南...', 100, 30, 1, 120);
INSERT INTO shixun_blog.blog (id, author, articleTitle, articleContent, articleCategories, publishDate, articleSummary, likes, collects, author_id, readed) VALUES (7, '王伟', 'Web 开发入门', '学习使用 HTML、CSS 和 JavaScript 制作基础的网页...', 'Web 开发', '2023-08-17', '创建网页的初学者指南...', 85, 20, 2, 80);
INSERT INTO shixun_blog.blog (id, author, articleTitle, articleContent, articleCategories, publishDate, articleSummary, likes, collects, author_id, readed) VALUES (8, '陈娟', '探索人工智能', '了解令人兴奋的人工智能世界及其应用...', '人工智能', '2023-08-16', '人工智能及其潜力概述...', 120, 40, 3, 150);
INSERT INTO shixun_blog.blog (id, author, articleTitle, articleContent, articleCategories, publishDate, articleSummary, likes, collects, author_id, readed) VALUES (9, '李强', '数据库设计基础', '学习设计高效且可扩展的数据库的原则...', '数据库', '2023-08-15', '数据库设计入门介绍...', 90, 25, 4, 60);
INSERT INTO shixun_blog.blog (id, author, articleTitle, articleContent, articleCategories, publishDate, articleSummary, likes, collects, author_id, readed) VALUES (10, '赵芳', '精通 CSS Flexbox 布局', '深入了解 Flexbox 布局模型，用于创建响应式网页设计...', 'Web 开发', '2023-08-14', '使用 CSS Flexbox 的全面指南...', 75, 18, 5, 90);
INSERT INTO shixun_blog.blog (id, author, articleTitle, articleContent, articleCategories, publishDate, articleSummary, likes, collects, author_id, readed) VALUES (11, '刘勇', '机器学习基础', '探索机器学习的基本原理及其算法...', '机器学习', '2023-08-13', '机器学习世界的入门介绍...', 110, 35, 6, 130);
INSERT INTO shixun_blog.blog (id, author, articleTitle, articleContent, articleCategories, publishDate, articleSummary, likes, collects, author_id, readed) VALUES (12, '杨秀', '健康生活小贴士', '了解保持健康和平衡生活方式的实用建议...', '健康', '2023-08-12', '养成健康习惯的建议...', 70, 15, 7, 75);
INSERT INTO shixun_blog.blog (id, author, articleTitle, articleContent, articleCategories, publishDate, articleSummary, likes, collects, author_id, readed) VALUES (13, '吴健', 'JavaScript 基础', '学习用于构建交互式网页的 JavaScript 编程基础...', 'Web 开发', '2023-08-11', 'JavaScript 编程入门介绍...', 105, 28, 8, 110);
INSERT INTO shixun_blog.blog (id, author, articleTitle, articleContent, articleCategories, publishDate, articleSummary, likes, collects, author_id, readed) VALUES (14, '张磊', '数据可视化技术', '探索各种数据可视化工具和技术，用于有效传达信息...', '数据科学', '2023-08-10', '数据可视化指南...', 95, 22, 9, 200);
INSERT INTO shixun_blog.blog (id, author, articleTitle, articleContent, articleCategories, publishDate, articleSummary, likes, collects, author_id, readed) VALUES (15, '王艳', '网络安全入门', '学习网络安全的基础知识，以及如何保护您的在线存在...', '网络安全', '2023-08-09', '网络安全原理概述...', 80, 20, 10, 45);
INSERT INTO shixun_blog.blog (id, author, articleTitle, articleContent, articleCategories, publishDate, articleSummary, likes, collects, author_id, readed) VALUES (16, '李刚', '响应式网页设计', '掌握创建能适应不同设备的响应式网页的技巧...', 'Web 开发', '2023-08-01', '响应式网页设计指南...', 85, 23, 11, 100);
INSERT INTO shixun_blog.blog (id, author, articleTitle, articleContent, articleCategories, publishDate, articleSummary, likes, collects, author_id, readed) VALUES (17, '周琴', '自然语言处理探索', '了解自然语言处理领域及其应用...', '自然语言处理', '2023-07-31', '自然语言处理概述...', 95, 30, 12, 170);
INSERT INTO shixun_blog.blog (id, author, articleTitle, articleContent, articleCategories, publishDate, articleSummary, likes, collects, author_id, readed) VALUES (18, '马军', '云计算入门', '了解云计算及其对个人和企业的好处...', '科技', '2023-07-30', '云计算入门介绍...', 110, 32, 13, 220);
INSERT INTO shixun_blog.blog (id, author, articleTitle, articleContent, articleCategories, publishDate, articleSummary, likes, collects, author_id, readed) VALUES (19, '张雯', '有效时间管理策略', '发现更有效管理时间并实现目标的技巧...', '效率', '2023-07-29', '优化时间利用的建议...', 75, 18, 14, 90);
INSERT INTO shixun_blog.blog (id, author, articleTitle, articleContent, articleCategories, publishDate, articleSummary, likes, collects, author_id, readed) VALUES (20, '王志', '了解神经网络', '深入探索神经网络及其在机器学习中的作用...', '机器学习', '2023-07-28', '神经网络概念入门介绍...', 120, 40, 15, 130);
INSERT INTO shixun_blog.blog (id, author, articleTitle, articleContent, articleCategories, publishDate, articleSummary, likes, collects, author_id, readed) VALUES (21, '刘慧', '数据分析入门', '探索使用 Python 和 Pandas 等库进行数据分析的技术...', '数据科学', '2023-07-27', '进行数据分析任务的指南...', 100, 30, 16, 120);
INSERT INTO shixun_blog.blog (id, author, articleTitle, articleContent, articleCategories, publishDate, articleSummary, likes, collects, author_id, readed) VALUES (22, '李敏', '深入了解 SQL 查询', '学习 SQL 查询的高级技巧和方法...', '数据库', '2023-07-26', 'SQL 查询深入指南...', 85, 20, 17, 80);
INSERT INTO shixun_blog.blog (id, author, articleTitle, articleContent, articleCategories, publishDate, articleSummary, likes, collects, author_id, readed) VALUES (23, '王娟', '人工智能伦理探讨', '探索人工智能伦理问题及其影响...', '人工智能', '2023-07-25', '人工智能伦理探讨...', 120, 40, 18, 150);
INSERT INTO shixun_blog.blog (id, author, articleTitle, articleContent, articleCategories, publishDate, articleSummary, likes, collects, author_id, readed) VALUES (24, '张翔', '网络隐私保护方法', '了解保护您的在线隐私的实用方法...', '网络隐私', '2023-07-24', '维护网络隐私的建议...', 90, 25, 19, 60);
INSERT INTO shixun_blog.blog (id, author, articleTitle, articleContent, articleCategories, publishDate, articleSummary, likes, collects, author_id, readed) VALUES (25, '李倩', '机器学习实战项目', '学习如何应用机器学习算法解决实际问题...', '机器学习', '2023-07-23', '机器学习实战项目介绍...', 75, 18, 20, 90);
INSERT INTO shixun_blog.blog (id, author, articleTitle, articleContent, articleCategories, publishDate, articleSummary, likes, collects, author_id, readed) VALUES (26, '王健', '数据可视化案例', '探索使用数据可视化技术呈现不同领域的案例...', '数据科学', '2023-07-22', '数据可视化案例探讨...', 100, 30, 21, 120);
INSERT INTO shixun_blog.blog (id, author, articleTitle, articleContent, articleCategories, publishDate, articleSummary, likes, collects, author_id, readed) VALUES (27, '张婷', '深度学习基础', '了解深度学习的基本原理和应用...', '机器学习', '2023-07-21', '深度学习入门介绍...', 85, 20, 22, 80);
INSERT INTO shixun_blog.blog (id, author, articleTitle, articleContent, articleCategories, publishDate, articleSummary, likes, collects, author_id, readed) VALUES (28, '李强', '前端框架比较', '比较不同前端框架的特点和用途...', 'Web 开发', '2023-07-20', '前端框架比较指南...', 120, 40, 23, 150);
INSERT INTO shixun_blog.blog (id, author, articleTitle, articleContent, articleCategories, publishDate, articleSummary, likes, collects, author_id, readed) VALUES (29, '刘琳', '网络安全攻防演练', '了解网络安全攻击和防御的技术...', '网络安全', '2023-07-19', '网络安全攻防实例探讨...', 90, 25, 24, 60);
INSERT INTO shixun_blog.blog (id, author, articleTitle, articleContent, articleCategories, publishDate, articleSummary, likes, collects, author_id, readed) VALUES (30, '王杰', '数据预处理技巧', '学习在数据分析前进行数据预处理的方法...', '数据科学', '2023-07-18', '数据预处理技巧指南...', 75, 18, 25, 90);

CREATE TABLE `comments` (
                            `id` int NOT NULL AUTO_INCREMENT COMMENT '评论id',
                            `uid` varchar(255) DEFAULT NULL COMMENT '评论者id',
                            `content` varchar(255) DEFAULT NULL,
                            `publishDate` datetime DEFAULT NULL,
                            `likes` int DEFAULT NULL,
                            `aid` int DEFAULT NULL COMMENT '评论id',
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;


CREATE TABLE `reply` (
                         `id` int NOT NULL AUTO_INCREMENT COMMENT '回复id',
                         `uid` int DEFAULT NULL COMMENT '回复者id',
                         `cid` int DEFAULT NULL COMMENT '评论id',
                         `contents` varchar(255) DEFAULT NULL COMMENT '内容',
                         `likes` int DEFAULT NULL,
                         `publishDate` datetime DEFAULT NULL,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='回复评论的id';


CREATE TABLE `user` (
                        `id` int NOT NULL AUTO_INCREMENT,
                        `username` varchar(255) NOT NULL,
                        `nickname` varchar(255) NOT NULL,
                        `phone` varchar(255) NOT NULL,
                        `email` varchar(255) NOT NULL,
                        `password` varchar(255) NOT NULL,
                        `registrationDate` datetime NOT NULL,
                        `birthday` datetime DEFAULT NULL,
                        `lastLogin` datetime DEFAULT NULL,
                        `isDelete` tinyint(1) NOT NULL DEFAULT '0',
                        `avatar` blob COMMENT '头像',
                        `gender` varchar(255) DEFAULT NULL COMMENT '性别',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;




